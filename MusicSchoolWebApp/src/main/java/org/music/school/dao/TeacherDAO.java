package org.music.school.dao;

import java.util.List;

import org.music.school.entity.Course;
import org.music.school.entity.Teacher;
import org.music.school.entity.TeacherDetail;

public interface TeacherDAO {
	
	public List<Teacher> getTeachers();
	public List<TeacherDetail> getTeacherDetails();
	
	// get a teacher based on the primary key
	public Teacher getTeacher(int id);
	public void saveTeacher(Teacher aTeacher);
	public void saveTeacherDetails(TeacherDetail teacherDetail);
	public void deleteTeacher(int theId);
	public void deleteTeacher(Teacher teacher);
	public List<Course> getCourses(int id);
	public List<Teacher> searchForTeacherByFirstName(String firstName);
	public List<Teacher> searchForTeacherByLastName(String lastName);

}
