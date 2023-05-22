package com.neymeha.myadminclientapplication.test.core;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.Arrays;

public class TestIOandNIO {
    public static void main(String[] args) throws IOException {
//        try(FileWriter writer=new FileWriter("test1.txt",true);FileReader reader=new FileReader("test1.txt")){
//            writer.write("привет как дела ");
//            int r;
//            while((r=reader.read())!=-1){
//                System.out.print((char)r);
//            }
//        }
//        try(FileWriter writer=new FileWriter("test1.txt",true);
//            FileReader reader=new FileReader("test1.txt");
//            BufferedReader bufferedReader = new BufferedReader(reader);
//            BufferedWriter bufferedWriter = new BufferedWriter(writer)){
//
//            String s="Hello Herman! ";
//            bufferedWriter.write(s,0,s.length());
//
//            System.out.println(bufferedReader.readLine());
//
//        }
//        try (RandomAccessFile r=new RandomAccessFile("test1.txt","rw")){
//            String s;
//            s=r.readLine();
//            System.out.println(s);
//
//        }
        ByteBuffer buffer= ByteBuffer.allocate(20);
        RandomAccessFile file = new RandomAccessFile("test1.txt", "rw");
        FileChannel channel = file.getChannel();

        char [] c=new String("fuck!").toCharArray();
        for (int i=0; i<c.length; i++){
            buffer.put((byte)c[i]);
        }

        buffer.flip();
        channel.write(buffer);

//

        channel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.print((char)buffer.get());
        }

        channel.close();
        file.close();
    }
}
