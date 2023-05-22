package com.neymeha.myadminclientapplication.test.core;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TestLambdaExpressions {

    static int x=1;
    public static void main(String[] args) {
        Function <String, String> function=(fullname)->{
            System.out.println("Mr. "+fullname);
            return fullname;
        };
        function.apply("Herman");

        System.out.println();

        List<String> list = new ArrayList<>();
        list.add("Herman");
        list.add("Kira");
        list.add("Sonya");
        list.add("Maya");
        list.forEach(s->System.out.println(s.toLowerCase()+" "+x++));

        System.out.println();

        list.forEach(System.out::println);
    }
}

