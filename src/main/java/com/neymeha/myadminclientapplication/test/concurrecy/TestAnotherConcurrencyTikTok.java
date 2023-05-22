package com.neymeha.myadminclientapplication.test.concurrecy;

import lombok.SneakyThrows;

class Main {

    static int count = 1;
    static Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        thread2.start();

    }




    static class Thread1 extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            synchronized (monitor) {
                for (int i = 0; i < 100; i++) {
                    if (count == 1) {
                        monitor.wait();
                    } else {
                        count = 1;
                        System.out.println(count);
                        monitor.notify();
                    }
                }
            }
        }
    }

    static class Thread2 extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            synchronized (monitor) {
                for (int i = 0; i < 100; i++) {
                    if (count == 2) {
                        monitor.wait();
                    } else {
                        count = 2;
                        System.out.println(count);
                        monitor.notify();
                    }
                }
            }
        }
    }

}


