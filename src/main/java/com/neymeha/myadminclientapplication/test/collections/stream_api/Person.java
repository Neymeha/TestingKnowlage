package com.neymeha.myadminclientapplication.test.collections.stream_api;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private String name;
    private String surname;
    private int age;
    private String occupation;
    private double salary;
    boolean sex;
    private String department;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                ", salary=" + salary +
                ", sex=" + sex +
                ", department='" + department + '\'' +
                '}';
    }

    public Person(String name, String surname, int age, String occupation, double salary, boolean sex) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.occupation = occupation;
        this.salary = Math.round(salary);
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getAge() == person.getAge() && Double.compare(person.getSalary(), getSalary()) == 0 && isSex() == person.isSex() && Objects.equals(getName(), person.getName()) && Objects.equals(getSurname(), person.getSurname()) && Objects.equals(getOccupation(), person.getOccupation()) && Objects.equals(getDepartment(), person.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getOccupation(), getSalary(), isSex(), getDepartment());
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(Person o) {
        return this.getAge()-o.getAge();
    }
}
