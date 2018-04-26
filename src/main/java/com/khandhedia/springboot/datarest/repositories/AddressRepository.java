package com.khandhedia.springboot.datarest.repositories;

import com.khandhedia.springboot.datarest.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RepositoryRestResource(path = "/libraryAddresses")
public interface AddressRepository extends CrudRepository<Address, Long>
{
    @RestResource(path = "findByIdAndName")
    Optional<Address> findByIdAndName(@Param("id") Long aLong, @Param("name") String name);
}
