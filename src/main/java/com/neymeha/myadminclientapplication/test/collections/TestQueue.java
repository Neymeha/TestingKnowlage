package com.neymeha.myadminclientapplication.test.collections;

import java.util.*;

public class TestQueue {
    public static void main(String[] args) {
        PriorityQueue <Integer> priorityQueue = new PriorityQueue<>(8);
        priorityQueue.add(-59);
        for (int i=-5; i<6;i++){
            priorityQueue.offer(i);
        }
        priorityQueue.add(75);
        System.out.println(priorityQueue);

        System.out.println("**********");

        Queue <Integer> linkedList = new LinkedList<>();
        linkedList.offer(-3);
        linkedList.offer(5);
        linkedList.offer(0);
        System.out.println(linkedList);
        System.out.println(linkedList.remove()+" removed elem");
        linkedList.add(-16);
        System.out.println(linkedList.peek()+" first elem");
        System.out.println(linkedList);

        Deque <Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.addFirst(3);
        deque.addLast(-3);
        System.out.println(deque);
    }
}
