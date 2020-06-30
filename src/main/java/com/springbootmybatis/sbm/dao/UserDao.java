package com.springbootmybatis.sbm.dao;


import com.springbootmybatis.sbm.model.UserModel;

import java.util.List;

/**
 * @author 11030
 */
public interface UserDao {
    List<UserModel> selAll();

    Integer selUser(UserModel userModel);

    Integer delUser(String id);

    UserModel selById(String id);

    Integer uptById(UserModel userModel);

    Integer insert(UserModel userModel);
}
