package testList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: cjx
 * @Date: 2021-01-27 10:19
 * @Description;
 */
public class ListDemo {

    @Test
    public void test1(){
        int n=1000000;
        fun1(n);
        fun2(n);
        fun3(n);
        fun4(n);
        fun5(n);
    }

    private void fun2(int n) {
        long s=System.currentTimeMillis();
        LinkedList<Integer> a = new LinkedList<>();
        for (int i = 0; i < n; i++) {
//            a.add(i);
            a.push(i);
        }

//        System.err.println("linklist--push===>n:"+n+"----时间："+(System.currentTimeMillis()-s));
//        System.err.println("linklist--push===>"+a.toString());
        read("linklist", "push", a);
    }
    private void fun3(int n) {
        long s=System.currentTimeMillis();
        LinkedList<Integer> a = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            a.addFirst(i);
        }

//        System.err.println("linklist--addFirst===>n:"+n+"----时间："+(System.currentTimeMillis()-s));
//        System.err.println("linklist--addFirst===>"+a.toString());
        read("linklist", "addFirst", a);
    }

  private void fun4(int n) {
        long s=System.currentTimeMillis();
        LinkedList<Integer> a = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            a.add(i);
        }

//        System.err.println("linklist--add===>n:"+n+"----时间："+(System.currentTimeMillis()-s));
//      System.err.println("linklist--add===>"+a.toString());
      read("linklist", "add", a);
    }
 private void fun5(int n) {
        long s=System.currentTimeMillis();
        LinkedList<Integer> a = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            a.addLast(i);
        }

//        System.err.println("linklist--addLast===>n:"+n+"----时间："+(System.currentTimeMillis()-s));
//      System.err.println("linklist--addLast===>"+a.toString());
     read("linklist", "addLast", a);
    }

    private void fun1(int n) {
        long s=System.currentTimeMillis();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(i);
        }
//        System.err.println("arraylist===>n:"+n+"----时间："+(System.currentTimeMillis()-s));
//        System.err.println("arraylist--add===>"+a.toString());
        read("arraylist", "add", a);
    }

    private void read(String type, String method, List list){
        long s=System.currentTimeMillis();
        Object o = list.get(list.size() / 2);
        System.err.println(type+method+":-时间："+(System.currentTimeMillis()-s));
    }
}
