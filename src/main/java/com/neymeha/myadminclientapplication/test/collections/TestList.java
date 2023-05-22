package com.neymeha.myadminclientapplication.test.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
//        List<String> arrayList=new ArrayList<>(3);
//
//        arrayList.add("Privet");
//        arrayList.add("Poka");
//        arrayList.add("Neznau");
//        arrayList.add("Neznau");
//        arrayList.add("null");
//
//        System.out.println(arrayList);
//
//        arrayList.forEach((x)->{
//            System.out.print(x.toLowerCase()+" ");
//        });
//        System.out.println();
//
//        arrayList.set(arrayList.indexOf("Privet"),"privet");
//
//        System.out.println(arrayList);
//
//        Collections.sort(arrayList);
//        System.out.println(arrayList);

        LinkedList <Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(6);
        linkedList.add(-3);
        linkedList.add(1);
        linkedList.add(null);

        System.out.println(linkedList);
        System.out.println(linkedList.getFirst()+" first element");
        System.out.println(linkedList.indexOf(-3));


    }
}
