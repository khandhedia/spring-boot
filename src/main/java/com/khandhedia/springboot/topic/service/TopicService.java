package com.khandhedia.springboot.topic.service;

import com.khandhedia.springboot.topic.dto.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private static List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("1", "one", "onedesc"), new Topic("2", "two", "twodesc")));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().orElse(null);
    }

    public void createTopic(Topic topic) {
        topics.add(topic);
    }

    public List<Topic> updateTopic(String id, Topic topic) {
        if (null != topic && id.equals(topic.getId())) {
            for (int index = 0; index < topics.size(); index++) {
                if (topics.get(index).getId().equals(id)) {
                    topics.set(index, topic);
                    break;
                }
            }
        }

        return getAllTopics();
    }

    public List<Topic> deleteTopic(String id) {

        topics.removeIf(topic -> topic.getId().equals(id));
        return getAllTopics();
    }
}


