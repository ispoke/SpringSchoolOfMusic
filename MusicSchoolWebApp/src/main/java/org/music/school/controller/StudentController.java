package org.music.school.controller;

import java.util.List;

import org.music.school.entity.Course;
import org.music.school.entity.Student;

import org.music.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		List<Student> students = studentService.getStudents();
		theModel.addAttribute("students", students);
		return "list-students";
	}
	
	@GetMapping("/showFormForAddStudent")
	public String showFormForAddStudents(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "add-student-form";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student newStudent) {
		
		studentService.saveStudent(newStudent);
		return "redirect:/student/list";
	}
	
	/* Show the List of Courses for the selected  student */
	@GetMapping("/showCoursesForStudent")
	public String showCoursesForStudent(@RequestParam("studentId") int studentId, Model model) {
		
		// retrieve the student
		Student theStudent = studentService.getStudent(studentId);
		model.addAttribute("student", theStudent);
		
		// retrieve the courses for this student
		List<Course> coursesForStudent = theStudent.getCourses();
		model.addAttribute("courses", coursesForStudent);
		
		return "show-courses-for-student";
	}
	

	/* *************** UPDATE AND DELETE STUDENT OPERATIONS ***************** */

	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("studentId") int studentId, Model model) {
		
		Student student = studentService.getStudent(studentId);

		model.addAttribute("student", student);
		
		return "update-student-form";
	}
	
	@PostMapping("/saveStudentUpdates")
	public String saveStudentUpdates(@ModelAttribute("student") Student theStudent) {
		/* Note: 
		 * When the update form is submitted, a new instance of Student.class is
		 * created and the courses collection is lost
		 * For this reason the student's courses has to be re-set here, otherwise the data is lost  */
		
		// Get the original instance of student from the database
		Student studentFromDB = studentService.getStudent(theStudent.getId());
		
		List<Course> coursesFromPrevious = studentFromDB.getCourses();
		
		// set the courses list for the new instance of Student
		theStudent.setCourse(coursesFromPrevious);
		
		studentService.saveStudent(theStudent);
		return "redirect:/student/list";
	}
		
	/* ************** Delete with Care *************** */
	@GetMapping("/deleteStudent")
	public String deleteTeacher(@RequestParam("studentId") int studentId) {
		
		studentService.deleteStudent(studentId);
		
		return "redirect:/student/list";
	}
	
}

 