package com.khandhedia.springboot.datarest.repositories;

import com.khandhedia.springboot.datarest.entities.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Long>
{

}
