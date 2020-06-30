package com.springbootmybatis.sbm.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springbootmybatis.sbm.model.UserModel;
import com.springbootmybatis.sbm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author szx
 */
@Controller
@RequestMapping("/user")
//实现跨域注解
//origin="*"代表所有域名都可访问
//maxAge飞行前响应的缓存持续时间的最大年龄，简单来说就是Cookie的有效期 单位为秒
//若maxAge是负数,则代表为临时Cookie,不会被持久化,Cookie信息保存在浏览器内存中,浏览器关闭Cookie就消失
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController{

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //用户列表
    @RequestMapping("/selAll")
    //@ResponseBody
    public String selAll(Model model) {
        List<UserModel> userList = userService.selAll();
        model.addAttribute("userList", userList);
        //return userList.toString();
        return "/userList";
    }

    //用户登录
    @RequestMapping("/selUser")
    public String selUser(HttpServletRequest request, UserModel userModel) {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("password");
        userModel.setUserName(userName);
        userModel.setPassWord(passWord);
        int count = userService.selUser(userModel);
        if (count != 0) {
            return "redirect:/user/selAll";
        } else {
            return "/error";
        }
    }

    //跳转到登录页面
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/login";
    }

    @RequestMapping("/delUser")
    public String delUser(String id) {
        int count = userService.delUser(id);
        return "redirect:/user/selAll";
    }

    @RequestMapping("/uptDetailToView")
    public String toUptDetailToView(String id, HttpServletRequest request) {
        UserModel userModel = userService.selById(id);
        request.setAttribute("userModel", userModel);
        return "/uptDetail";
    }

    @RequestMapping("/updtUser")
    @ResponseBody
    public String updtUser(HttpServletRequest request, String js) {
        String str = request.getParameter("js");
        JSONObject jsonObject = JSONObject.parseObject(str);
        UserModel userModel = JSON.toJavaObject(jsonObject, UserModel.class);
        Integer count = userService.uptById(userModel);
        return "";
    }

    @RequestMapping("/insertUser")
    public String insertUser() {
        return "/insertUser";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(HttpServletRequest request) {
        UserModel userModel = new UserModel();
        String str = "注册成功";
        userModel.setUserName(request.getParameter("userName"));
        userModel.setPassWord(request.getParameter("passWord"));
        userModel.setRealName(request.getParameter("realName"));
        Integer count = userService.insert(userModel);
        return str;
    }

    @RequestMapping("/selById")
    @ResponseBody
    public UserModel selById(String id, HttpServletRequest request) {
        UserModel userModel = userService.selById(id);
        request.setAttribute("userModel", userModel);
        return userModel;
    }

    //testGitCommitIsSuccess?



}
