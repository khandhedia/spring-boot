package com.khandhedia.springboot.topic.service;

import com.khandhedia.springboot.topic.dto.Topic;
import com.khandhedia.springboot.topic.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicServiceWithDB
{
    @Autowired TopicRepository topicRepository;

    public List<Topic> getAllTopics()
    {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id)
    {
        return topicRepository.findById(id).orElse(null);
    }

    public void createTopic(Topic topic)
    {
        topicRepository.save(topic);
    }

    public List<Topic> updateTopic(String id, Topic topic)
    {
        if (null != topic && id.equals(topic.getId()))
        {
            topicRepository.save(topic);
        }

        return getAllTopics();
    }

    public List<Topic> deleteTopic(String id)
    {
        topicRepository.deleteById(id);
        return getAllTopics();
    }

    public List<Topic> getTopicsByCustomFilter(String filter)
    {
        return topicRepository.getTopicsByCustomFilter(filter);
    }
}


