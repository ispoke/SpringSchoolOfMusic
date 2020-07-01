package org.music.school.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="instrument")
	private String instrument;
	
	@Column(name="level")
	private String level;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,  // Fine tune CascadeType to avoid Cascade Remove
						CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="teacher_id")
	private Teacher teacher;
	
	@ManyToMany(fetch=FetchType.LAZY,			//  Hibernate does not support lazy Initialization of detached objects
			cascade= {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="course_student",
			   joinColumns=@JoinColumn(name="course_id"),
			   inverseJoinColumns=@JoinColumn(name="student_id")
			  )
	private List<Student> students; 	// uninitialized collection is being accessed from out side the Hibernate Session
	
	//constructors
	public Course() {}

	public Course(String title, String instrument, String level, Teacher teacher) {
		this.title = title;
		this.instrument = instrument;
		this.level = level;
		this.teacher = teacher;
	}
	
	// setters & getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}	
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	// Support / convenience method to add a student to the course
	public void addStudent(Student student) {
		
		if(students == null) {
			students = new ArrayList<>();
		}
		
		students.add(student);

	}
	
	// Support method to remove a student from a course's list of students
	public void removeStudent(Student student) {
		
		if(students != null) {
			// find the index in the list of the student
			boolean found = false;
			int index = 0;
			
			Iterator<Student> it = students.iterator();
			while(it.hasNext() && !found) {
				if(it.next().getId() == student.getId()) {
					 found = true;	 
				}else {
					index++;
				}
			}
			students.remove(index);
		}
		
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instrument=" + instrument + ", level=" + level + "]";
	}	
	
}
