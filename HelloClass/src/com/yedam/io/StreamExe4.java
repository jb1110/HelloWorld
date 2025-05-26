package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * 객체 입출력 스트림
 * 기본타입 - 참조타입
 * int num - 10;
 * Member member =  new Member();
 * 직렬화(Serialization) : 객체 -> 기본
 * 역직렬화(Deserialization)
 * Serializable 인터페이스 구현 클래스.
 */
class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    String prodCode;

    public Product(String prodCode) { // 매개변수 이름 수정
        this.prodCode = prodCode;
    }
}

public class StreamExe4 {
    public static void main(String[] args) {

    	InputStream is = new FileInputStream("c:/temp/object.db");

        System.out.println("prog end");
    }
    
    static void serial() {
        List<Product> list = new ArrayList<>(); 
        list.add(new Product("P001"));
        list.add(new Product("P002"));

        try {
            // 기본 스트림.
            OutputStream os = new FileOutputStream("c:/temp/object.db");
            // 객체 입출력 보조 스트림.
            ObjectOutputStream oos = new ObjectOutputStream(os);
            // 객체 직렬화
            oos.writeObject(list); // 객체 -> 기본
            oos.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
