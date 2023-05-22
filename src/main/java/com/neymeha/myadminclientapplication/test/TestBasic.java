package com.neymeha.myadminclientapplication.test;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestBasic {
    public static List <CustomNumbers> produceCustomNumbersList(int count){
        List <CustomNumbers> customNumbersList=new ArrayList<>();
        for (int i=0; i<count*10; i+=10){
            customNumbersList.add(new CustomNumbers(i,i+10));
        }
        return customNumbersList;
    }
    public static void main(String[] args) {
//        Stream <String> m=Stream.of("A","B","C");
//        List<String> strings=m.map(e->e.toString().toLowerCase()).collect(Collectors.toList());
//        strings.stream().forEach(System.out::println);

//        CustomNumbers cN=new CustomNumbers(1,10);
//        cN.showCustomNumbers();



    }
}

class CustomNumbers {
    private List <Integer> integers = new ArrayList<>();

    private void produce(int start, int end){
        for (int i=start; i<end; i++){
            integers.add(i);
        }
    }

    public CustomNumbers(int from, int to) {
        produce(from,to);
    }

    public void showCustomNumbers(){
        System.out.print("Start: ");
        for(Integer i:integers){
            System.out.print(i+" ");
        }
        System.out.print("End!");
        System.out.println();
    }

    public List <Integer> getCustomNumbersList(){
        return integers;
    }
}