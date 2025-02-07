package com.college.student.serviceimpl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.dao.StudentDao;
import com.college.student.feign.CourseInterface;
import com.college.student.feign.FeesInterface;
import com.college.student.model.Course;
import com.college.student.model.FeesHistory;
import com.college.student.model.Student;
import com.college.student.model.StudentProfile;
import com.college.student.repository.StudentRepository;
import com.college.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private CourseInterface courseInterface;
	
	@Autowired
	private FeesInterface feesInterface;

	@Override
	public String admitStudent(Student student) {

		String res = "";
		try {
			studentDao.addStudent(student);

			List<Student> students = studentDao.getStudentsListForFeesUpdate();
			logger.info("Stduent Fees Update List : " + students.size());
			
			try {
				for (Student studentFees : students) {
					feesInterface.saveFees(Integer.toString(studentFees.getStudentCode()), studentFees.getName(),
							studentFees.getDepartment(), studentFees.getYear(), studentFees.getType());
					String update = studentDao.updateStudentFeesStaus(studentFees.getStudentCode(), "Updated");
					if (StringUtils.equalsIgnoreCase(update, "success")) {
						logger.info("Student Fees Details updated successfully : " + studentFees.toString());
					}
				}
				res = "Student Admission Success : " + student.toString();
			} catch (Exception e) {
				logger.info("Exception occured while updating stduent fees details :"+e);
			}
			
		} catch (Exception e) {
			logger.info("Exception occured while admitting stduent :"+e);
			res = "Student Admission Failed";
		}
		logger.info(res);
		return res;
	}

	@Override
	public String terminateStudent(int id,Student student) {
		String res ="";
		try {
			studentDao.terminateStudent(id);
			res = "Student Termination Success :"+student.toString();
		}catch (Exception e) {
			logger.info("Exception occured while terminating student :"+e);
			res="Student Termination Failed";
		}
		logger.info(res);
		return res;
	}

	@Override
	public Student getStudentDataById(int id) {
		Student stud = null;
		try {
			stud = studentDao.getStudentData(id);
		} catch (Exception e) {
			logger.info("Exception occured while getting student details  :"+e);
						
		}
		return stud;
	}

	@Override
	public List<Student> getStudentData() {
		List<Student>  stud = null;
		try {
			stud = studentDao.getAllStudents();
		} catch (Exception e) {
			logger.info("Exception occured while getting student data :"+e);
						
		}
		return stud;
	}

	@Override
	public StudentProfile getStudentProfile(int id) {
		StudentProfile profile = new StudentProfile();
		
		try {
			
			Student studentDetails = getStudentDataById(id);
			if(studentDetails!=null) {
				ResponseEntity<List<Course>> course = courseInterface.getStudentCourse(studentDetails.getDepartment(), studentDetails.getYear());			
				List<Course> courseDetails = course.getBody();
				if(courseDetails!=null) {
					ResponseEntity<List<FeesHistory>> fees = feesInterface.getStudentFeesDetails(Integer.toString(id), studentDetails.getDepartment());
					List<FeesHistory> feesDetails = fees.getBody();
					if(feesDetails!=null) {
						profile.setId(Integer.toString(id));
						profile.setAdmissionType(studentDetails.getType());
						profile.setBatch(studentDetails.getBatch());
						profile.setName(studentDetails.getName());
						profile.setDepartment(studentDetails.getDepartment());
						profile.setYear(studentDetails.getYear());
						profile.setFeesStatus(studentDetails.getFeesStatus());
						profile.setCourses(courseDetails);
						profile.setFees(feesDetails);				
					}
				}
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
		logger.info(profile.toString());
		return profile;
	}

	@Override
	public String getUpdateFeesStatus(int id, String status) {
		return studentDao.updateStudentFeesStaus(id, status);
	}
	

}
