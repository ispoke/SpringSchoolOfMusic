package org.music.school.controller;

import java.util.ArrayList;
import java.util.List;

import org.music.school.entity.Course;
import org.music.school.entity.Teacher;
import org.music.school.entity.TeacherDetail;
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
@RequestMapping("/teacher")		
public class TeacherController {
	
	private static Teacher thisTeacher = new Teacher();
	
	// Inject the TeacherService
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("/list")
	public String listTeachers(Model theModel) {
		
		// get the list of teachers from the DAO
		List<Teacher> teachers = teacherService.getTeachers();
		
		// add the teachers to the model
		theModel.addAttribute("musicTeachers", teachers);
		
		return "list-teachers";
	}

	// Controller mapping handler to get data for new teacher
	@GetMapping("/showFormForAddTeacher")
	public String showFormForAddTeacher(Model theModel) {
		
		Teacher teacher= new Teacher();
		theModel.addAttribute("teacher", teacher);
		return "add-teacher-form";
	}
	
	@PostMapping("/saveTeacher")
	public String saveTeacher(@ModelAttribute("teacher") Teacher newTeacher, Model model) {

		// save the teacher to memory 
		thisTeacher.setFirstName(newTeacher.getFirstName());
		thisTeacher.setLastName(newTeacher.getLastName());
		thisTeacher.setEmail(newTeacher.getEmail());
		
		// Now get the teacherDetails
		TeacherDetail teacherDetails = new TeacherDetail();
		model.addAttribute("teacher", newTeacher);
		model.addAttribute("teacherDetails", teacherDetails);
		return "teacher-details-form";
	}
	
	@PostMapping("/saveTeacherDetails")
	public String saveTeacherDetails(@ModelAttribute("teacherDetails") TeacherDetail teacherDetails) {
		
		// get the teacher from memory
		Teacher newTeacher = new Teacher(thisTeacher.getFirstName(),
										thisTeacher.getLastName(),
										thisTeacher.getEmail());
	
		// Set the new teacher's details
		newTeacher.setTeacherDetail(teacherDetails);
		
		// Save the teacher and teacher details by cascade save
		teacherService.saveTeacher(newTeacher);
		return "redirect:/teacher/list";
	}
	
	/*************   Updates  *************/
	@GetMapping("/showTeacherDetailsForm")
	public String updateTeacherDetails(@RequestParam("teacherId") int id, Model model) {
		
		Teacher theTeacher= teacherService.getTeacher(id);
		TeacherDetail teacherDetail = theTeacher.getTeacherDetail();
		
		model.addAttribute("teacherDetails", teacherDetail);
		// show the teacher in the form
		model.addAttribute("teacher", theTeacher);
	
		return "update-teacher-details-form";
	}
	
	@PostMapping("/saveUpdatesForTeacherDetails")
	public String saveUpdatedTeacherDetails(@ModelAttribute("teacherDetails") TeacherDetail teacherDetail){
		
		// save the details directly to the teacherDetails table
		teacherService.saveTeacherDetails(teacherDetail);
		return "redirect:/teacher/list";
	}
	
	// need to update Teacher here!!!
	@GetMapping("/updateTeacherForm")
	public String updateTeacher(@RequestParam("teacherId") int id, Model model) {
		
		// get the teacher
		Teacher theTeacher = teacherService.getTeacher(id);
		
		// Add the teacher to the model
		model.addAttribute("teacher", theTeacher);
		
		// show the teacher in the update form
		return "update-teacher-form";
	}
	
	@PostMapping("/saveTeacherUpdates")
	public String updateTeacher(@ModelAttribute("teacher") Teacher theTeacher) {
		System.out.println("UPDATING TEACHER!!!!");
		System.out.println("Teacher updated to: "+ theTeacher);
		teacherService.saveTeacher(theTeacher);
		return "redirect:/teacher/list";
	}
	
	// will also need to showCourses for each teacher

			
	/* ************** Delete with Care *************** */
	@GetMapping("/deleteWithCare")
	public String deleteTeacher(@RequestParam("teacherId") int theId) {
		
		Teacher teacher = teacherService.getTeacher(theId);
		/* Note: Deleting the teacher using Id does NOT cascade delete the TeacherDetail */
		/* Deleting teacher object cascade deletes the teacherDetail because of CascadeType.ALL */
		
		// See if the teacher is appointed to teach courses
		List<Course> coursesByThisTeacher = teacherService.getCourses(theId);
		if (coursesByThisTeacher.isEmpty()) {
			teacherService.deleteTeacher(teacher);
		}else {
			System.out.println("YOU CANNOT DELETE A Teacher while they are in active service !!");
			System.out.println("Assign a different teacher or delete the course(s) they are teaching first");
			for(Course course: coursesByThisTeacher) {
				System.out.println("Course: "+ course.getTitle());
			}
		}
		return "redirect:/teacher/list";
	}
	
	/* ************* Show Courses For the Teacher ***********/
	@GetMapping("/showCourses")
	public String showCourses(@RequestParam("teacherId") int id, Model model) {
		
		// get the teacher
		Teacher theTeacher = teacherService.getTeacher(id);
		model.addAttribute("teacher", theTeacher);
		
		List<Course> courses = teacherService.getCourses(id);
		model.addAttribute("courses", courses);
		
		return "show-courses-for-teacher";
	}
	
	@GetMapping("/showSearchTeacherForm")
	public String searchForTeacher() {
	
		// Present a form asking the user to enter a first name, last name or teacher id
		return "search-teacher-form";
	}
	
	@PostMapping("/searchTeacher")
	public String searchTeacher(@RequestParam("firstName") String firstName, 
								@RequestParam("lastName") String lastName,  Model model) {
		
		List<Teacher> teachers = new ArrayList<>();
		
		if( !(firstName.trim().contentEquals(""))) {
			System.out.println("First Name is not NULL !!!");
			teachers = teacherService.searchForTeacherByFirstName(firstName);
			model.addAttribute("teachersFound", teachers);
		}else if (!(lastName.trim().contentEquals(""))) {
				teachers = teacherService.searchForTeacherByLastName(lastName);
				model.addAttribute("teachersFound", teachers);
		}
			
		return "search-result-list";
	}	
	
}
