package com.springbootmybatis.sbm.service.impl;

import com.springbootmybatis.sbm.dao.UserDao;
import com.springbootmybatis.sbm.model.UserModel;
import com.springbootmybatis.sbm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 11030
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<UserModel> selAll() {
        return userDao.selAll();
    }

    @Override
    public Integer selUser(UserModel userModel) {
        return userDao.selUser(userModel);
    }

    @Override
    public Integer delUser(String id) {
        return userDao.delUser(id);
    }

    @Override
    public UserModel selById(String id) {
        return userDao.selById(id);
    }

    @Override
    public Integer uptById(UserModel userModel) {
        return userDao.uptById(userModel);
    }

    @Override
    public Integer insert(UserModel userModel) {
        return userDao.insert(userModel);
    }
}
