package com.springbootmybatis.sbm.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserModel implements Serializable {
    private Integer id;
    @Excel(name = "姓名", orderNum = "0")
    private String userName;
    @Excel(name = "密码", orderNum = "1")
    private String passWord;
    private String realName;
    private String perms;

    private int ttt;
    boolean yyyy;

    private Person person;
    private User user;



}
