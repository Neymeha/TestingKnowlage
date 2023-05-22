package com.neymeha.myadminclientapplication.test.collections.stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {
    private String name;
    private List<Person> departmentWorkers;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getDepartmentWorkers() {
        if(departmentWorkers==null){
            return new ArrayList<>();
        }
        return departmentWorkers;
    }

    public void setDepartmentWorkers(List<Person> departmentWorkers) {
        this.departmentWorkers = departmentWorkers;
    }

    public void addWorkerToDepartment(Person person){
        if (departmentWorkers!=null){
            departmentWorkers.add(person);
            person.setDepartment(this.name);
        } else {
            departmentWorkers=new ArrayList<>();
            departmentWorkers.add(person);
            person.setDepartment(this.name);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department that)) return false;
        return getName().equals(that.getName()) && Objects.equals(getDepartmentWorkers(), that.getDepartmentWorkers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDepartmentWorkers());
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", departmentWorkers=" + departmentWorkers +
                '}';
    }
}
