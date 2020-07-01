package org.music.school.dao;

import java.util.List;

import org.music.school.entity.Course;

public interface CourseDAO {

	public List<Course> getCourses();
	public void saveCourse(Course course);
	public Course getCourse(int id);
	public void deleteCourse(int courseId);

}
