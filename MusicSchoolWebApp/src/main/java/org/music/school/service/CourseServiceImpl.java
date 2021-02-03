package org.music.school.service;

import java.util.List;

import org.music.school.dao.CourseDAO;
import org.music.school.entity.Course;
import org.music.school.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDAO courseDAO;
	
	@Override
	@Transactional
	public List<Course> getCourses() {
		List<Course> courses = courseDAO.getCourses();
		return courses;
	}
	
	@Override
	@Transactional
	public void saveCourse(Course course) {
		courseDAO.saveCourse(course);
	}

	@Override
	@Transactional
	public Course getCourse(int id) {
		
		return courseDAO.getCourse(id);
	}

	@Override
	@Transactional
	public void deleteCourse(int courseId) {
		
		courseDAO.deleteCourse(courseId);
	}

	@Override
	@Transactional
	public void addStudentToCourse(Course course, Student student) {
		
		course.addStudent(student);
	}
	
	@Override
	@Transactional
	public void delistStudentFromCourse(Course course, Student student) {
		course.removeStudent(student);
	}
}
		
		
		
		