package com.khandhedia.springboot.topic.repository;

import com.khandhedia.springboot.topic.dto.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, String> {


    @Query(value = "SELECT  id, name, description  FROM Topic WHERE  description = :filter", nativeQuery = true)
    List<Topic> getTopicsByCustomFilter(@Param("filter") String filter);

}
