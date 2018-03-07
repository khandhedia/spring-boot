package com.khandhedia.springboot.topic.repository;

import com.khandhedia.springboot.topic.dto.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {


}
