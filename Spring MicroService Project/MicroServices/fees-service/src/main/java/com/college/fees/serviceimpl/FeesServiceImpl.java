package com.college.fees.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.fees.controller.FeesController;
import com.college.fees.dao.FeesDao;
import com.college.fees.feign.StudentInterface;
import com.college.fees.model.Fees;
import com.college.fees.model.FeesHistory;
import com.college.fees.repository.FeesHistoryRepository;
import com.college.fees.service.FeesService;


@Service
public class FeesServiceImpl implements FeesService {
	
	private static final Logger logger =  LoggerFactory.getLogger(FeesServiceImpl.class);
	
	@Autowired
	FeesDao feesDao;
	
	@Autowired
	FeesHistoryRepository feesHistoryRepo;
	
	@Autowired
	StudentInterface studentinterface;

	@Override
	public List<Fees> getFees() {
		
		List<Fees> fees = new ArrayList<Fees>();
		try {
			fees= feesDao.getAllFees();			
		} catch (Exception e) {
			
		}	
		return fees;
	}

	@Override
	public FeesHistory saveStudentFees(String studentCode, String name, String department, String year,String type) {
		
		FeesHistory feesHistory = new FeesHistory();	
		try {
			
			Fees fees = feesDao.getFeesForStudnet(department,year,type);
			if(fees!=null) {
				feesHistory.setName(name);
				feesHistory.setDepartment(department);
				feesHistory.setYear(year);
				feesHistory.setStudentCode(studentCode);
				feesHistory.setFeesAmount(fees.getTotalFees());
				feesHistory.setPendingAmount(fees.getTotalFees());
				feesHistoryRepo.save(feesHistory);
			}
			
			
		} catch (Exception e) {
			logger.info("Exception occured while saving fees :"+e);
		}
		return feesHistory;
	}

	@Override
	public String checkFeesExists(String studentCode, String department, String year) {
		String res="";
		try {
			
			FeesHistory fees = feesHistoryRepo.checkFeesData(studentCode,department,year);
			
			if(fees!=null) {
				res="Exists";
			}else {
				res="Not exists";
			}
			
		} catch (Exception e) {
			
		}
		return res;
	}

	@Override
	public List<FeesHistory> getStudentFees(String studentCode, String department) {
		List<FeesHistory> fees = new ArrayList<FeesHistory>();
		try {
			 fees = feesHistoryRepo.getStudentFeesData(studentCode,department);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return fees;
	}

	@Override
	public String payStudentFee(String studentCode, String department, String year, int amount) {
		String res=studentCode+"|"+department+"|"+year+"|";
		try {
			FeesHistory fees = feesHistoryRepo.checkFeesData(studentCode, department, year);
			if(fees!=null) {
				res+=fees.getName();
				if(!StringUtils.equalsIgnoreCase(fees.getFeesPaid(), "Y")) {
					int totalFee = fees.getFeesAmount(), paidFee = fees.getPaidAmount(),
							pendingFee = fees.getPendingAmount();
					
					boolean paymentSuccess= false;
					if(amount<=pendingFee) {
						try {
							fees.setPaidAmount(paidFee+amount);
							fees.setPendingAmount(totalFee - (paidFee+amount));
							if(fees.getPendingAmount()==0) {
								fees.setFeesPaid("Y");
							}
							feesHistoryRepo.save(fees);
							paymentSuccess=true;
						}catch (Exception e) {
							logger.info("Exception occured during payemnt : "+e);
							paymentSuccess=false;
						}				
					}else {
						res+="|Excess Amount given . Please only pay the pending amount :"+pendingFee;
					}
					
					if(paymentSuccess) {
						try {
							studentinterface.updateStudentFeeStatus(Integer.valueOf(studentCode),fees.getFeesPaid()=="Y"?"Completed":"Partial");
							res+="|Payment Success";
						}catch (Exception e) {
							logger.info("Exception occured while update Student fee status : "+e);
							res+="|No Fees Details Found . Payment Failed";
						}
						
					}
					
				}else {
					res+="|No Pending Fees for Student";
				}
			}else {
				res+="|No Fees Details Found . Payment Failed";
			}
		} catch (Exception e) {
			res+="|Payment Failed";
		}
		logger.info(res);
		return res;
	}

}
