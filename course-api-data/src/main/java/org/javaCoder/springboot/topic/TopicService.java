package org.javaCoder.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics=new ArrayList<>(Arrays.asList(new Topic("Spring","Spring Framework","spring Framework Description"),
			 								 new Topic("Java","Core Java","Core Java Description"),
			 								 new Topic("JavaScript","JavaScript","JavaScript Description")
			 								 ));
	//to get all topics
	public List<Topic> getAllTopics(){
		
		List<Topic> topics=new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	//to get a single topic
	public Optional<Topic> getTopic(String id) {
		
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
	}
	//to add a topic
	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
		
	}
	//to update a topic
	public void updateTopic(String id,Topic topic) {
		
//		for(int i=0; i<topics.size();i++) {
//			Topic t=topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i,topic);
//				return;
//			}
		topicRepository.save(topic);
		}
		//to delete a topic
	public void deleteTopic(String id) {
		
		//topics.removeIf(t->t.getId().equals(id));
		topicRepository.deleteById(id);
	}
	

}
