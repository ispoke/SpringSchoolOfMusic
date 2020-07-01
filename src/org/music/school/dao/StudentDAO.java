package org.music.school.dao;

import java.util.List;

import org.music.school.entity.Course;
import org.music.school.entity.Student;

public interface StudentDAO {
	public List<Student> getStudents();

	public void saveStudent(Student student);

	public Student getStudent(int studentId);
	

	public void deleteStudent(int studentId);

	public List<Course> getCoursesForStudent(int studentId);
	
}
