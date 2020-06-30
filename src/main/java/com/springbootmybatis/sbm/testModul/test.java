package com.springbootmybatis.sbm.testModul;

import java.util.ArrayList;
import java.util.List;

public class test {


    public static void main(String[] args) {

        /*Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "val=====123");
        boolean b = map.containsValue("val=====1234");
        System.out.println(b);*/

        List list = new ArrayList();
        list.add("111");
        boolean contains = list.contains("111");
        System.out.println(contains);


    }

}
