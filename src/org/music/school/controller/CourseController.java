package org.music.school.controller;

import java.util.List;

import org.music.school.entity.Course;
import org.music.school.entity.Student;
import org.music.school.entity.Teacher;
import org.music.school.service.CourseService;
import org.music.school.service.StudentService;
import org.music.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/course")
public class CourseController {

	// Inject the Course Service
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentService;
	
	private static int COURSE_ID;
	
	@RequestMapping("/list")
	public String listCourses(Model theModel) {		
		
		// get the courses from the DAO
		List<Course> courses = courseService.getCourses();
		
		// add the courses to the Model
		theModel.addAttribute("musicCourses", courses);
		
		// show the list in list-courses.jsp
		return "list-courses";		
	}
	
	@GetMapping("/showFormForAddCourse")
	public String showFormForAddCourse(Model theModel) {
		
		Course course = new Course();
		theModel.addAttribute("course", course);
		return "add-course-form";
	}
	
	@PostMapping("/saveCourse")
	public String saveCourse(@ModelAttribute("course") Course newCourse) {
		
		// To Do: In the Form, there will have to be a list of teachers
		// Leave it null for now
		
		// Will have to get the Teacher and set it with course.setTeacher()
		
		// save the new course 
		courseService.saveCourse(newCourse);
		
		return "redirect:/course/list";
	}
	
	@GetMapping("/assignTeacherForm")
	public String getTeacherForm(@RequestParam("courseId") int courseId, Model theModel) {
		
		// store the course Id
		COURSE_ID= courseId;
		
		// get the course
		Course theCourse = courseService.getCourse(courseId);
		theModel.addAttribute("course", theCourse);
		
		// use Teacher list in the assign form to assign a teacher to the course
		List<Teacher> musicTeachers = teacherService.getTeachers();
		theModel.addAttribute("musicTeachers", musicTeachers);
		return "assign-teacher-to-course";
	}
	
	@PostMapping(("/assignTeacher") )
	public String assignTeacherToCourse(@RequestParam("teacher") int teacherId) {
		System.out.println("Got the Teacher ID -:"+ teacherId);
		// get the course
		Course course = courseService.getCourse(COURSE_ID);
		
		Teacher courseTeacher = teacherService.getTeacher(teacherId);
		System.out.println( "New Teacher Assigned: "+courseTeacher.getFirstName()+" "+ courseTeacher.getLastName());
		System.out.println("to course: "+ course);
		// assign the teacher
		course.setTeacher(courseTeacher);
		System.out.println("Teacher has been assigned to course: "+ course);
		
		// save the update
		courseService.saveCourse(course);
		
		// return to course list
		return "redirect:/course/list";
	}
	
	@GetMapping("/showStudentsEnrolled")
	public String showStudents(@RequestParam("courseId") int courseId, Model model) {
		
		Course course = courseService.getCourse(courseId);
		List<Student> students = course.getStudents();
		model.addAttribute("course", course);
		model.addAttribute("students", students);
		return "show-students-for-course";
	}
	
	/*
	 * Add student to course
	 * Remove student to course to be implemented here
	 */
	@GetMapping("/addStudentToCourse")
	public String addStudentToCourse(@RequestParam("courseId") int courseId, Model model) {
		COURSE_ID = courseId;
		Course course = courseService.getCourse(courseId);
		List<Student> allStudents = studentService.getStudents();
		model.addAttribute("course", course);
		model.addAttribute("students", allStudents);
		
		return "course-student-enlist-delist-form";
	}
	
	@GetMapping("/saveStudentToCourse")
	public String saveStudentToCourse(@RequestParam("studentId") int studentId) {
		
		// get the course back
		Course course = courseService.getCourse(COURSE_ID);
		
		// get the student
		Student student = studentService.getStudent(studentId);
		
		// add the student to the course's student list
		course.addStudent(student);
		
		// save the update
		courseService.saveCourse(course);
		return "redirect:/course/list";
	}
	
	
	@GetMapping("/removeStudentFromCourse")
	public String removeStudentFromCourse(@RequestParam("courseId") int courseId, Model model) {
		COURSE_ID = courseId;
		Course course = courseService.getCourse(courseId);
		List<Student> enrolledStudents = course.getStudents();
		model.addAttribute("course", course);
		model.addAttribute("students", enrolledStudents);
		
		return "course-student-enlist-delist-form";
	}
	
	@GetMapping("/delistStudentFromCourse")
	public String delistStudentFromCourse(@RequestParam("studentId") int studentId) {
		// get the course back
				Course course = courseService.getCourse(COURSE_ID);
				
				// get the student
				Student student = studentService.getStudent(studentId);
				
				// remove the student form the course's student list
				course.removeStudent(student);
				
				// save the update
				courseService.saveCourse(course);
				
		return "redirect:/course/list";
	}
	
	// Update the course
	@GetMapping("/updateCourseForm")
	public String showCourseUpdateForm(@RequestParam("courseId") int courseId, Model model) {
		/*
		 * Course update form will allow the administrator to
		 * update course title, course instrument and level. 
		 * Teacher can be assigned or re-assigned via the re-assign link.
		 */
		Course course = courseService.getCourse(courseId);
		model.addAttribute("course", course);
		
		return "course-update-form";
	}
	
	@PostMapping("/saveCourseUpdates")
	public String saveCourseUpdates(@ModelAttribute("course") Course updatedCourse) {
		
		/* WARNING!! - This will cause the loss of mapped data e.g teacher and students because a new  
		 *  course instance is created when the update form is submitted
		 * this is why the list of students is retrieved from the saved course and set for updated course 
		 * ***********************************************************************************************/
		Course savedCourse = courseService.getCourse(updatedCourse.getId());
		List<Student> students = savedCourse.getStudents();
		updatedCourse.setStudents(students);
		
		//save the updates
		courseService.saveCourse(updatedCourse);
		return "redirect:/course/list";
	}
	
	@GetMapping("/deleteCourse")
	public String deleteCourse(@RequestParam("courseId") int courseId) {
		
		courseService.deleteCourse(courseId);
		return "redirect:/course/list";
	}
}
