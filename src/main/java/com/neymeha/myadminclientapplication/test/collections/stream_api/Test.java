package com.neymeha.myadminclientapplication.test.collections.stream_api;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        // создаем обьекты для работы с ними через Stream API(создаем в утилитарном классе с помощью Stream API)
        List<Department> depList=CreateData.createDepartmentsList("HR","IT","MANAGEMENT","SALES");
        List<Person> perList1=CreateData.createRandomPersonsList(10);
        List<Person> perList2=CreateData.createRandomPersonsList(10);

        // конкатенация стримов и дальнешая фильтрация с целью добавления отфильтрованных и обьединенных данных в коллекцию
        depList.get(0).setDepartmentWorkers(Stream.concat(perList1.stream(),perList2.stream()).filter(p->p.sex==true).
                collect(Collectors.toList()));
        // сортировка
        depList.get(1).setDepartmentWorkers(perList1.stream().sorted().collect(Collectors.toList()));
        // тут что то пошло не так, хотел добавить в коллекцию список работников с заполненным полем Департамента, но
        // вызвав метод в .map() все покраснело, не смог разобарться
        depList.get(2).setDepartmentWorkers(perList2.stream()
                .map(p->new Person("p.getName()","p.getSurname()",p.getAge(),p.getOccupation(),p.getSalary(),p.isSex()))
                .collect(Collectors.toList())); //почему в мап я не смог вызвать метод .setDepartment("Management") ????

        // находим первого работника с фильтрацией, чисто тестировал Optional
        Optional<String> worker = perList1.stream().
                filter(person -> person.getAge()<30).map(person -> person.getName()+" "+person.getSurname()).findFirst();
        // Среднюю зарпалту высчитываю среди всех работников находящихся в коллекции, пытался сначала перевести все
        // в double stream через mapToDouble, там тоже есть метод average(), но что то пошло не так. В итоге не разобрался
        // и остановился на таком варианте
        Double averageSalary=depList.stream()
                .flatMap(department -> department.getDepartmentWorkers().stream())
                .collect(Collectors.averagingDouble(p->p.getSalary()));

        // группировка в мапу по данным
        Map <Integer, List <Person>> personByAge=perList1.stream().collect(Collectors.groupingBy(p->p.getAge()));
        // группировка в мапу по логике
        Map <Boolean, List <Person>> personBySex=Stream.concat(perList1.stream(),perList2.stream())
                        .collect(Collectors.partitioningBy(person -> person.isSex()==true));

        System.out.println("first worker below age 30: "+worker.get()+"\n ------------------");
        System.out.println("average salary of workers at all departments: "+averageSalary+"\n ------------------");

        System.out.println("female persons: "+personBySex+"\n ------------------");
        System.out.println("persons by age asc: "+personByAge+"\n ------------------");

        depList.forEach(System.out::println);

    }
}
