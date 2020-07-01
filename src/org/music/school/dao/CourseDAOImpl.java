package org.music.school.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.music.school.entity.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDAOImpl implements CourseDAO {
	
	// inject Hibernate Session Factory dependency
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Course> getCourses() {
	
		// get the current Hibernate session
		Session thisSession = sessionFactory.getCurrentSession();

		// create a query using HQL 5.2 org.hibernate.query.Query
		Query<Course> theQuery = 
				thisSession.createQuery("from Course ", Course.class);
		
		// execute the query and return the result
		return theQuery.getResultList();
	}

	@Override
	public void saveCourse(Course course) {
		// get the current Hibernate session
		Session thisSession = sessionFactory.getCurrentSession();
		
		// Save or Update the  Course
		thisSession.saveOrUpdate(course);
		
	}

	@Override
	public Course getCourse(int courseId) {
		Session thisSession = sessionFactory.getCurrentSession();
		
		Course course =  thisSession.get(Course.class, courseId);
		
		//*****Initialize student collection*******
		if(!(Hibernate.isInitialized(course.getStudents()))) {
			Hibernate.initialize(course.getStudents());  // force initialization of the students collection to avoid a lazyInitializationException
		}
		
//		Query<Course> query = thisSession.createQuery("select crs from Course crs JOIN FETCH crs.students "
//									+ "where crs.id=:theId", Course.class);
//		// set parameter on query
//		query.setParameter("theId", courseId);
// 		Course course = query.getSingleResult();
		return course;
	}

	@Override
	public void deleteCourse(int courseId) {
		Session thisSession = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("rawtypes") 
		Query theQuery = 
				thisSession.createQuery("delete from Course where id=:courseId");
		// match the query id parameter to the actual id
		theQuery.setParameter("courseId", courseId);
		
		// execute the query with generic 'executeUpdate'
		theQuery.executeUpdate();
		
	}

	
}
