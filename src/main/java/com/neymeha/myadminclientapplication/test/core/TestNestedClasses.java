package com.neymeha.myadminclientapplication.test.core;

public class TestNestedClasses {
    public static void main(String[] args) {

        Animal.Dog dog=new Animal.Dog("","");
        dog.start();

        new Animal(){
            @Override
            public void say(){
                System.out.println("fuck off");
            }
        }.say();
    }
}

class Animal {
    private String sex="male";

    public Animal() {

    }

    public void say(){
        System.out.println("im not ur animal!");
    }

    static class Dog extends Mammel{
        private String callname;

        public Dog(String callname, String name) {
            this.callname = callname;
            this.name=name;
//            say();
        }

        public void start(){
            System.out.println("My name "+name+" and my sex is "+" and my callname "+callname);
        }
    }
}

class Mammel{
    protected String name;
    public void walk(){
        System.out.println("i go for a walk");
    }
}
