package org.music.school.service;

import java.util.List;

import org.music.school.dao.StudentDAO;
import org.music.school.entity.Course;
import org.music.school.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		List<Student> students = studentDAO.getStudents();
		return students;
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);
	}

	@Override
	@Transactional
	public Student getStudent(int studentId) {
		return studentDAO.getStudent(studentId);
	}

	@Override
	@Transactional
	public List<Course> getCoursesForStudent(Student student) {
		
		return student.getCourses();
	}
	
	@Override
	@Transactional
	public List<Course> getCoursesForStudent(int studentId) {
		
		return studentDAO.getCoursesForStudent(studentId);
	}
	

	@Override
	@Transactional
	public void deleteStudent(int studentId) {
		
		studentDAO.deleteStudent(studentId);
	}
	

}
