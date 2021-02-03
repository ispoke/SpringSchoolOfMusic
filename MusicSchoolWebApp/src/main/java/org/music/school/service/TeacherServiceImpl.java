package org.music.school.service;

import java.util.List;

import org.music.school.dao.TeacherDAO;
import org.music.school.entity.Course;
import org.music.school.entity.Teacher;
import org.music.school.entity.TeacherDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDAO teacherDAO;
	
	@Override
	@Transactional
	public List<Teacher> getTeachers() {
		return teacherDAO.getTeachers();
	}

	@Override
	@Transactional 
	public List<TeacherDetail> getTeacherDetails(){
		return teacherDAO.getTeacherDetails();
	}
	
	@Override
	@Transactional
	public Teacher getTeacher(int id) {
		return teacherDAO.getTeacher(id);
	}
	
	@Override
	@Transactional
	public void saveTeacher(Teacher aTeacher) {
		teacherDAO.saveTeacher(aTeacher);
	}

	@Override
	@Transactional
	public void saveTeacherDetails(TeacherDetail teacherDetail) {
		teacherDAO.saveTeacherDetails(teacherDetail);
		
	}

	@Override
	@Transactional
	public void deleteTeacher(int theId) {
		teacherDAO.deleteTeacher(theId);
	}

	@Override
	@Transactional
	public void deleteTeacher(Teacher teacher) {
		teacherDAO.deleteTeacher(teacher);
	
	}

	@Override
	@Transactional
	public List<Course> getCourses(int id) {
		
		return teacherDAO.getCourses(id);
	}

	@Override
	@Transactional
	public List<Teacher> searchForTeacherByFirstName(String firstName) {
		
		return teacherDAO.searchForTeacherByFirstName(firstName);
	}

	@Override
	@Transactional
	public List<Teacher> searchForTeacherByLastName(String lastName) {
		
		return teacherDAO.searchForTeacherByLastName(lastName);
	}

}
