package org.music.school.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.music.school.entity.Course;
import org.music.school.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Student> getStudents() {
	  // get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Student> theQuery = currentSession.createQuery("FROM Student ", Student.class);
		List<Student> students = theQuery.getResultList();
		return students;
	}

	@Override
	public void saveStudent(Student student) {
		// get the Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(student);
		
	}

	@Override
	public Student getStudent(int studentId) {
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Student student = currentSession.get(Student.class, studentId);
		
		// Initialise the course collection in Student while the session is open
		//  otherwise we'll get a lazyIntializationException
		if(!Hibernate.isInitialized(student.getCourses())) {
			Hibernate.initialize(student.getCourses());
		}
		
		// execute the query and return
		return student;
	}

	@Override
	public void deleteStudent(int studentId) {
		Session thisSession = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("rawtypes")
		Query theQuery = thisSession.createQuery("delete from Student where id=:theId");
		theQuery.setParameter("theId", studentId);
		
		theQuery.executeUpdate();
	}

	@Override
	/* get the list of courses for the student */
	public List<Course> getCoursesForStudent(int studentId) {
		Session thisSession = sessionFactory.getCurrentSession();
		
		Query<Course> theQuery = thisSession.createQuery("select from Student s "
							+ "join s.courses where id=:studentId", Course.class);
		theQuery.setParameter("studentId", studentId);
		return theQuery.getResultList();
	}

}
