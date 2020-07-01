package org.music.school.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {

	// annotate the class as an Entity and map to database table
	// define the fields 
	// annotate the fields with db column name
	// set up mapping 
	// create constructors
	// create getters & setters
	// create toString method
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // for auto-increment
	@Column(name="id")
	private int id; 
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade= CascadeType.ALL)       
	@JoinColumn(name="teacher_detail_id")
	private TeacherDetail teacherDetail;
	
	@OneToMany(mappedBy="teacher")  
	private List<Course> courses;
	
	// constructors
	public Teacher() {}

	public Teacher(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	// getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TeacherDetail getTeacherDetail() {
		return teacherDetail;
	}

	public void setTeacherDetail(TeacherDetail teacherDetail) {
		this.teacherDetail = teacherDetail;
	}

	// convenience method for bi-directional Teacher-Course relationship
	public void addCourse(Course newCourse) {
		if(courses == null) {
			courses = new ArrayList<>();
		}
		
		courses.add(newCourse);
		newCourse.setTeacher(this);
	}
		
	public List<Course> getCourses() {
		return courses;
	}

	// toString - helps with printing object
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+  "]";
	}
	

	
}
