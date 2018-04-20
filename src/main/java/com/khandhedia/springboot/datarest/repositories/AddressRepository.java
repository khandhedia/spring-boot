package com.khandhedia.springboot.datarest.repositories;

import com.khandhedia.springboot.datarest.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/libraryAddresses")
public interface AddressRepository extends CrudRepository<Address, Long>
{}
