package com.neymeha.myadminclientapplication.test.concurrecy;

import lombok.SneakyThrows;

import static java.lang.Thread.sleep;

public class TestConcurencyTikTokWaitNotify{

    public static void main(String[] args) {

        TikOrTok tikOrTok=new TikOrTok();
        Tik tik = new Tik(tikOrTok);
        Tok tok = new Tok(tikOrTok);

        new Thread(tik).start();
        new Thread(tok).start();
    }
}

final class TikOrTok {
    private static boolean tikOrTok=true;
    @SneakyThrows
    synchronized public void tik () {
        while (!TikOrTok.tikOrTok) {
            wait();
        }
        System.out.println("tik");
        TikOrTok.tikOrTok=!TikOrTok.tikOrTok;
        sleep(1000);
        notify();
    }
    @SneakyThrows
    synchronized public void tok () {
        while (TikOrTok.tikOrTok) {
            wait();
        }
        System.out.println("tok");
        TikOrTok.tikOrTok=!TikOrTok.tikOrTok;
        sleep(1000);
        notify();
    }
}

class Tik implements Runnable {

    private final TikOrTok tik;
    public Tik(TikOrTok tik) {
        this.tik=tik;
    }

    @Override
    public void run() {
        tik.tik();
        this.run();
    }
}

class Tok implements Runnable {

    private final TikOrTok tok;
    public Tok(TikOrTok tok) {
        this.tok=tok;
    }

    @Override
    public void run() {
        tok.tok();
        this.run();
    }
}