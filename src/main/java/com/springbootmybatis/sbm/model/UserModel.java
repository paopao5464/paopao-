package com.springbootmybatis.sbm.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserModel implements Serializable {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
}
