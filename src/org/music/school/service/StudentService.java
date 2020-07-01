package org.music.school.service;

import java.util.List;

import org.music.school.entity.Course;
import org.music.school.entity.Student;

public interface StudentService {

	public List<Student> getStudents();

	public void saveStudent(Student student);

	public Student getStudent(int studentId);

	public List<Course> getCoursesForStudent(Student student);
	public List<Course> getCoursesForStudent(int studentId);

	public void deleteStudent(int studentId);

}
