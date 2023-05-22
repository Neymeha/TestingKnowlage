package com.neymeha.myadminclientapplication.test.collections.stream_api;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class CreateData {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();
    public static List<Department> createDepartmentsList(String...name){
        return Arrays.stream(name).map(n->new Department(n)).collect(Collectors.toList());
    }

    public static List<Person> createRandomPersonsList(int count){
        return Arrays.stream(new Person[count]).map(p->new Person(faker.name().firstName(),faker.name().lastName(),
                faker.number().numberBetween(20,50),faker.company().profession(),
                faker.number().randomDouble(2,1000,5000),random.nextBoolean())).collect(Collectors.toList());
    }
}
