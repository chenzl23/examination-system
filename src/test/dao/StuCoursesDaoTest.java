package test.dao; 

import dao.StuCoursesDao;
import model.StuCourses;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 


public class StuCoursesDaoTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: addStuCourse(StuCourses stuCourses) 
* 
*/ 
@Test
public void testAddStuCourse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateStuCourse(StuCourses stuCourses) 
* 
*/ 
@Test
public void testUpdateStuCourse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteStuCourse(int sc_id) 
* 
*/ 
@Test
public void testDeleteStuCourse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: searchStuCourse(int sc_id) 
* 
*/ 
@Test
public void testSearchStuCourse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: searchStuScore(String sno) 
* 
*/ 
@Test
public void testSearchStuScore() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: searchTeacher(int term, int cno) 
* 
*/ 
@Test
public void testSearchTeacher() throws Exception { 
//TODO: Test goes here...
    StuCoursesDao dao = new StuCoursesDao();
    dao.searchTeacher(2015,2);
} 

/** 
* 
* Method: getScoreByTeacher(int term, String teacher, int cno) 
* 
*/ 
@Test
public void testGetScoreByTeacher() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getCoursesOf(int term, String teacher) 
* 
*/ 
@Test
public void testGetCoursesOf() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: searchCoursesName(int term) 
* 
*/ 
@Test
public void testSearchCoursesName() throws Exception { 
//TODO: Test goes here... 
} 


} 
