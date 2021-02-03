package org.music.school.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="teacher_detail")   // mapped to this table in the database
public class TeacherDetail {
	
	//fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="instrument_1")
	private String instrument1;
	
	@Column(name="instrument_2")
	private String instrument2;
	
	@Column(name="webpage")
	private String webpage;
	
	//  bi-directional mapping - back to teacherDetail field in Teacher class
	@OneToOne(mappedBy="teacherDetail", cascade= {CascadeType.DETACH, CascadeType.MERGE,
						CascadeType.REFRESH, CascadeType.PERSIST})  
	private Teacher teacher;
	 
	// constructors
	public TeacherDetail() {}

	public TeacherDetail(String instrument1, String instrument2, String webpage) {
		this.instrument1 = instrument1;
		this.instrument2 = instrument2;
		this.webpage = webpage;
	}

	// getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstrument1() {
		return instrument1;
	}

	public void setInstrument1(String instrument1) {
		this.instrument1 = instrument1;
	}

	public String getInstrument2() {
		return instrument2;
	}

	public void setInstrument2(String instrument2) {
		this.instrument2 = instrument2;
	}

	public String getWebpage() {
		return webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	//getter & setter for teacher 
	public Teacher getTeacher(){ return teacher; }

	public void setTeacher(Teacher teacher){
	    this.teacher = teacher;
	}
	
	// toString
	@Override
	public String toString() {
		return "TeacherDetail [id=" + id + ", instrument1=" + instrument1 + ", instrument2=" + instrument2
				+ ", webpage=" + webpage + "]";
	}

}
