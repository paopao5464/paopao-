package com.springbootmybatis.sbm.service;

import com.springbootmybatis.sbm.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> selAll();

    Integer selUser(UserModel userModel);

    Integer delUser(String id);

    UserModel selById(String id);

    Integer uptById(UserModel userModel);

    Integer insert(UserModel userModel);
}
