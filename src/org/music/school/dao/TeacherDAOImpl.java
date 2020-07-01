package org.music.school.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.music.school.entity.Course;
import org.music.school.entity.Teacher;
import org.music.school.entity.TeacherDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository		// Register this DAO implementation in Spring 
public class TeacherDAOImpl implements TeacherDAO {

	// Inject Hibernate Session Factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Teacher> getTeachers() {
		
		//get the current Hibernate session
		Session thisSession = sessionFactory.getCurrentSession();
		
		// Create a Hibernate Query HQL 5 : Use class name in query
		Query<Teacher> teacherQuery = thisSession.createQuery("from Teacher", Teacher.class);
				
		List<Teacher> teachers = teacherQuery.getResultList();
		// Execute query and return result
		return  teachers;		
	}
	
	@Override
	public List<TeacherDetail> getTeacherDetails(){
		
		// get the current Hibernate Session
		Session thisSession = sessionFactory.getCurrentSession();
		
		// Create the Query: HQL uses the class name instead of the db table 
		Query<TeacherDetail> detailsQuery = thisSession.createQuery("from TeacherDetail", TeacherDetail.class);
		
		// Execute the query
		List<TeacherDetail> teacherDetailsList = detailsQuery.getResultList();
		
		// Return the list
		return teacherDetailsList;
	}
	
	@Override
	public Teacher getTeacher(int theId) {
		// get the current Hibernate Session
		Session thisSession = sessionFactory.getCurrentSession();
		
		Teacher theTeacher = thisSession.get(Teacher.class, theId);
	
		return theTeacher;
	}
	
	@Override
	public void saveTeacher(Teacher theTeacher) {
		// get the current Hibernate session
		Session thisSession = sessionFactory.getCurrentSession();
		
		// Save or Update the Teacher object
		thisSession.saveOrUpdate(theTeacher);
	}

	@Override
	public void saveTeacherDetails(TeacherDetail teacherDetail) {
		// get the current Hibernate session
		Session thisSession = sessionFactory.getCurrentSession();
				
		// Save or Update the TeacherDetail object
		thisSession.saveOrUpdate(teacherDetail);		
	}

	@Override
	public void deleteTeacher(int theId) {
		Session thisSession = sessionFactory.getCurrentSession();
		
		/* HQL does NOT support Cascading and will therefore NOT cascade the delete operation	*
		 * HQL query to delete the teacher object (only) matching the id 						*/
		
		@SuppressWarnings("rawtypes") // Query gives a Raw Type warning but no fix for the moment
		Query theQuery = 
				thisSession.createQuery("delete from Teacher where id=:teacherId");
		// match the query id parameter to the actual id
		theQuery.setParameter("teacherId", theId);
		
		// execute the query with generic 'executeUpdate'
		theQuery.executeUpdate();
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		Session thisSession = sessionFactory.getCurrentSession();
		thisSession.delete(teacher);
	}

	@Override
	public List<Course> getCourses(int id) {
		Session thisSession = sessionFactory.getCurrentSession();
		
		// Query Course by teacher Id
		Query<Course> courseQuery = 
				thisSession.createQuery("from Course where teacher_id=:teacherId", Course.class);
		courseQuery.setParameter("teacherId", id);		
		List<Course> courses = courseQuery.getResultList();
		return courses;
	}

	@Override
	public List<Teacher> searchForTeacherByFirstName(String firstName) {
		// get a hibernate session
		Session thisSession = sessionFactory.getCurrentSession();
		
		// create a HQL query to search for teacher by first name
		String hqlSearch = "FROM Teacher t WHERE t.firstName LIKE:name";
		@SuppressWarnings("unchecked")
		Query<Teacher> theQuery = thisSession.createQuery(hqlSearch);
		theQuery.setParameter("name", firstName);
		
		List<Teacher> teachers = theQuery.getResultList();
		// execute the query and return the result list
		return teachers;
	}

	@Override
	public List<Teacher> searchForTeacherByLastName(String lastName) {
		Session thisSession = sessionFactory.getCurrentSession();
		
		// create a HQL query to search for teacher by last name
				String hqlSearch = "FROM Teacher t WHERE t.lastName LIKE:name";
				@SuppressWarnings("unchecked")
				Query<Teacher> theQuery = thisSession.createQuery(hqlSearch);
				theQuery.setParameter("name", lastName);
				
				List<Teacher> teachers = theQuery.getResultList();
				
				// execute the query and return the result list
				return teachers;
	}
	
}












