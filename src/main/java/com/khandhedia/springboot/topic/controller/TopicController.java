package com.khandhedia.springboot.topic.controller;

import com.khandhedia.springboot.topic.dto.Topic;
import com.khandhedia.springboot.topic.service.TopicServiceWithDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicServiceWithDB topicService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Topic getTopic(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
        Topic topic = topicService.getTopic(id);
        if (null == topic) {
            try {
                response.sendRedirect("/topics");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return topic;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public List<Topic> createTopic(@RequestBody Topic topic) {
        topicService.createTopic(topic);
        return getAllTopics();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public List<Topic> updateTopic(@PathVariable("id") String id, @RequestBody Topic topic) {
        return topicService.updateTopic(id, topic);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<Topic> deleteTopic(@PathVariable("id") String id) {
        return topicService.deleteTopic(id);
    }

    @RequestMapping(value="/inject", method = RequestMethod.POST)
    public List<Topic> injectSQL(@RequestBody Topic topic)
    {
        return topicService.getTopicsByCustomFilter(topic.getDescription());
    }


}
