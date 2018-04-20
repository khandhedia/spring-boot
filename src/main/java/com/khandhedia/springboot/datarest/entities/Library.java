package com.khandhedia.springboot.datarest.entities;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/*
Library and Address are two different entities. They would represent two different tables in the database.
Library entity has reference to Address attribute.
Each Library can have ONLY ONE address and EACH Address can be associated with only one library.

While we  added below dependency in the POM, it takes care of exposing REST API for accessing data source i.e. entities and provides possible operations as ReST APIs.
Of course, we must have a corresponding Repository interfaces in the code (as a bean).

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-rest</artifactId>
        </dependency>


With this, if you start the app, on the localhost:8080, you will get to see the HATEOAS providing you all possible links that you can access in the application.
Here, you will get to see the links for /libraries and /addresses.

These URL Paths are self decided as plural of the entity names.

However, if these are required to be different, one needs to put an annotation
@RepositoryRestResource

example, @RepositoryRestResource(path = "/libraryAddresses")

Now, we need to create initial data.
Let's create one Address entry using POST /libraryAddresses
And one Library entry using POST /libraries

Now, we need to associate library and address.

As we understand, Libraray holds  the reference of Address.
So, we need to do a PUT /libraries/1/libraryAddress with content-type as "text/uri-list"
and the body should be a URL like  http://localhost:8080/librarayAddresses/4


@OneToOne annotation defines the possible column mapping as  1-1. Others like 1-many, many-1 etc can be also defined using appropriate annotations
@RestResource


 */



@Entity
public class Library
{
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "libraryAddress")
    @RestResource(path = "libraryAddressPath", rel = "libraryAddress")
    private Address address;

    public Library(String name)
    {
        this.name = name;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Library()
    {
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Library{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
