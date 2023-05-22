package com.neymeha.myadminclientapplication.test.core;


import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TestAnnotationAndReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        List <Cat> cats=new ArrayList<>();
        cats.add(new MeinKun("Tom","Simferopol"));
        cats.add(new British("Mark","Kerch"));
        cats.add(new Bengal("Fluffy","Sevastopol"));

        Class clazz;
        for (Cat cat:cats){
            clazz=cat.getClass();
            Annotation [] annotations=clazz.getAnnotations();
            for (Annotation annotation:annotations){
                if(annotation instanceof MagicCat) {
                    Field [] fields=cat.getClass().getSuperclass().getDeclaredFields();
                    for (Field field:fields){
                        if(field.getName().equals("name")){
                            field.setAccessible(true);
                            field.set(cat,"Vasya");
                        }
                    }
                    System.out.println(cat.name+" has a power - "+((MagicCat) annotation).value());
                }
            }
        }




    }
}

abstract class Cat{
    String name;
    String home;

    public Cat(String name, String home) {
        this.name = name;
        this.home = home;
    }

    public void says(){
        System.out.println("meow-meow");
    }

    abstract void play();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHome(String home) {
        this.home = home;
    }
}

@MagicCat
class MeinKun extends Cat{

    public MeinKun(String name, String home) {
        super(name, home);
    }

    @Override
    void play() {
        System.out.println("play with water");
    }
}

@MagicCat("Flying")
class British extends Cat{
    public British(String name, String home) {
        super(name, home);
    }

    @Override
    void play() {
        System.out.printf("play with toy");
    }
}

class Bengal extends Cat{
    public Bengal(String name, String home) {
        super(name, home);
    }

    @Override
    void play() {

    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MagicCat{
    String value() default "Fire Ball";
}
