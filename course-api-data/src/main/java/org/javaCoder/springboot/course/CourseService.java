package org.javaCoder.springboot.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	//to get all courses
	public List<Course> getAllCourses(String topicId){
		
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
	//to get a single course
	public Optional<Course> getCourse(String id) {
		
		return courseRepository.findById(id);
	}
	//to add a course
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	//to update a course
	public void updateCourse(Course course) {
		courseRepository.save(course);
		}
		//to delete a topic
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
	

}
