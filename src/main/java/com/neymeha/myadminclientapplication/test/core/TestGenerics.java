package com.neymeha.myadminclientapplication.test.core;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics {

    public static void printCreatures(List <?> creatures) {
//        creatures.get(0).hashCode(); // не можем использовать методы класса
        printList(creatures);
    }

    public static <T> void printList(List <T> creatures){
//        creatures.get(0).hashCode(); // не можем использовать методы класса
        creatures.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Bird<String>> birds = new ArrayList<>();
        birds.add(new Bird<>(2, "ocean"));
        birds.add(new Vorobei(2,"ground","Vasya"));
//        birds.add(new Creature(2));
        int i=birds.get(0).konechnosti; // можем использовать методы класса

        System.out.println();

        List <? super Bird<String>> creatures = new ArrayList<>();
//        creatures.add(new Creature(2));
        creatures.add(new Bird<String>(2, "mountain"));
        creatures.add(new Vorobei(2,"tree","Pipa"));
        System.out.println(creatures.get(1));
        i=creatures.get(1).hashCode(); // не можем использовать методы класса

        System.out.println();

        List <? extends Bird<String>> birdies = new ArrayList<>();
//        birdies.add(new Bird<String>(2,"home"));
        birdies.add(null);
//        birdies.add(new Vorobei(2,"rock","Mama"));
//        birdies.add(new Creature(2));
        System.out.println(birdies.get(0));
//        i=birdies.get(0).konechnosti; // можем использовать методы класса

        System.out.println();

        printCreatures(creatures);

        System.out.println();
        printCreatures(birds);

        System.out.println();
        printCreatures(birdies);

        System.out.println();


//        birds=birdies;
        birdies=birds;
        System.out.println(birdies.get(0));
//        birdies=creatures;
//        birds=creatures;
        creatures=birds;
//        creatures=birdies;
        System.out.println(creatures.get(1));
     }
}

class Creature {
    int konechnosti;

    public Creature(int konechnosti) {
        this.konechnosti = konechnosti;
    }

    public Creature() {
    }

    public int getKonechnosti() {
        return konechnosti;
    }

    public void setKonechnosti(int konechnosti) {
        this.konechnosti = konechnosti;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "konechnosti=" + konechnosti +
                '}';
    }
}

class Bird <T> extends Creature {
    T type;

    public Bird(int konechnosti, T type) {
        super(konechnosti);
        this.type = type;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public Bird() {
    }

    @Override
    public String toString() {
        return "Bird{" +
                "type=" + type +
                ", konechnosti=" + konechnosti +
                '}';
    }
}

class Vorobei extends Bird <String> {
    String name;

    public Vorobei(int konechnosti, String type, String name) {
        super(konechnosti, type);
        this.name = name;
    }

    public Vorobei() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vorobei{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", konechnosti=" + konechnosti +
                '}';
    }
}
