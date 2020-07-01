package org.music.school.service;

import java.util.List;

import org.music.school.entity.Course;
import org.music.school.entity.Student;

public interface CourseService {
	
	public List<Course> getCourses();

	public void saveCourse(Course course);
	public Course getCourse(int id);

	public void deleteCourse(int courseId);

	public void addStudentToCourse(Course course, Student student);
	public void delistStudentFromCourse(Course course, Student student);
	
}
