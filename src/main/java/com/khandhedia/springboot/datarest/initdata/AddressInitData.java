package com.khandhedia.springboot.datarest.initdata;

import com.khandhedia.springboot.datarest.entities.Address;
import com.khandhedia.springboot.datarest.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class AddressInitData implements CommandLineRunner
{

    @Autowired
    AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception
    {

        Stream.of("addr1", "addr2", "addr3").forEach(
                s -> addressRepository.save(new Address(s))
        );
    }
}
