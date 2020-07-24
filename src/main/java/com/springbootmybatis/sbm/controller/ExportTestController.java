package com.springbootmybatis.sbm.controller;


import com.springbootmybatis.sbm.model.Person;
import com.springbootmybatis.sbm.model.UserModel;
import com.springbootmybatis.sbm.service.UserService;
import com.springbootmybatis.sbm.utils.FileUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/exportTest")
public class ExportTestController {

    @Autowired
    private UserService userService;

    @RequestMapping("export")
    public void export(HttpServletResponse response, HttpServletRequest request, UserModel userModel){

        //模拟从数据库获取需要导出的数据

        List<Person> personList = new ArrayList<>();

        List<UserModel> userList = userService.selAll();

        /*for (int i =0;i<1000000;i++){
            Person person = new Person(userList.get,"1" + i,new Date());
            personList.add(person);
        }*/

        /*Person person1 = new Person("路飞","1",new Date());
        Person person2 = new Person("娜美","2", new Date());
        Person person3 = new Person("索隆","1", new Date());
        Person person4 = new Person("小狸猫","1", new Date());
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);*/

        //导出操作
        FileUtil.exportExcel(userList,"花名册","草帽一伙",UserModel.class,"海贼王.xls",response);
    }

    @SneakyThrows
    @RequestMapping("importExcel")
    public void importExcel(){
        String filePath = "F:\\海贼王.xls";
        //解析excel，
        List<Person> personList = FileUtil.importExcel(filePath,1,1,Person.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");

        //TODO 保存数据库
    }



}
