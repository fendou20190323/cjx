package com.fendou.moudle.controller;

import com.fendou.moudle.model.test.TestTransient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * @Author: cjx
 * @Date: 2020-06-12 09:56
 * @Description;
 */
@RestController
@RequestMapping("/testTransient")
public class TestTransientController {

    @GetMapping("/getInfo")
    public TestTransient getInfo(){
        return new TestTransient("a","c");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        outPutStream();
//        inputStream();
    }

    private static void inputStream() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("C:\\Users\\EDZ\\Desktop\\c\\a.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TestTransient o = (TestTransient)ois.readObject();
        System.err.println(o.toString());
        ois.close();
        fis.close();
    }

    private static void outPutStream() throws IOException {
        TestTransient testTransient = new TestTransient("a", "c");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\EDZ\\Desktop\\c\\a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(testTransient);
        oos.close();
        fos.close();
    }
}
