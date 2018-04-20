package com.khandhedia.springboot.datarest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address
{
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToOne(mappedBy = "address")
    private Library library;

    public Address(String name)
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

    public Library getLibrary()
    {
        return library;
    }

    public void setLibrary(Library library)
    {
        this.library = library;
    }

    public Address()
    {
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", library=").append(library);
        sb.append('}');
        return sb.toString();
    }
}
