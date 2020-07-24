package com.springbootmybatis.sbm.testModul;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {


    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("2");

        Set set = new HashSet<>(list);
        //set.clear();
        System.out.println(set.toString());


    }

}
