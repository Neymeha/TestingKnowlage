package com.neymeha.myadminclientapplication.test.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestSet {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Privet");
        hashSet.add("net");
        hashSet.add("Privet"); // ne dobavit
        System.out.println(hashSet);
        hashSet.add("f");
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        System.out.println(hashSet); // ne zapominaet poryadok dobavleniya

        System.out.println("/////////////");

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Privet");
        linkedHashSet.add("net");
        linkedHashSet.add("Privet"); // ne dobavit
        System.out.println(linkedHashSet);
        linkedHashSet.add("f");
        linkedHashSet.add("a");
        linkedHashSet.add("b");
        linkedHashSet.add("c");
        System.out.println(linkedHashSet); // zapominaet

        System.out.println("///////////");

        TreeSet <Integer> treeSet = new TreeSet<>();
        for (int i=-5; i<6; i++){
            treeSet.add(i);
        }
        treeSet.add(123);
        treeSet.add(-321);
        System.out.println(treeSet);
        System.out.println(treeSet.size());
    }
}
