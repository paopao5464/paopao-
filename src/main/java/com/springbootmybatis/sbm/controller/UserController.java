package com.springbootmybatis.sbm.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootmybatis.sbm.model.Person;
import com.springbootmybatis.sbm.model.User;
import com.springbootmybatis.sbm.model.UserModel;
import com.springbootmybatis.sbm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author szx
 * <p>
 * //实现跨域注解
 * //origin="*"代表所有域名都可访问
 * //maxAge飞行前响应的缓存持续时间的最大年龄，简单来说就是Cookie的有效期 单位为秒
 * //若maxAge是负数,则代表为临时Cookie,不会被持久化,Cookie信息保存在浏览器内存中,浏览器关闭Cookie就消失
 */

@Controller
@RequestMapping("/user")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

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

    /**
     * 跳转到登出页面
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/login";
    }

    @RequestMapping("/delUser")
    public String delUser(String id) {
        userService.delUser(id);
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
        userService.uptById(userModel);
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
        userService.insert(userModel);
        return str;
    }

    @RequestMapping("/selById")
    @ResponseBody
    public UserModel selById(String id, HttpServletRequest request) {
        UserModel userModel = userService.selById(id);
        request.setAttribute("userModel", userModel);
        return userModel;
    }

    @RequestMapping("/sel")
    @ResponseBody
    Map sel(HttpServletRequest request) throws IOException {
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
        }
        return JSON.parseObject(responseStrBuilder.toString(), Map.class);
    }

    @RequestMapping("/millionInsert")
    @ResponseBody
    public String millionInsert(HttpServletRequest request) {
        int num = 100000;
        for (int i = 0; i < num; i++) {
            UserModel userModel = new UserModel();
            userModel.setUserName(request.getParameter("userName"));
            userModel.setPassWord(request.getParameter("passWord"));
            userModel.setRealName(request.getParameter("realName"));
            userService.insert(userModel);
        }
        return "百万数据插入成功!";
    }


    @ResponseBody
    @RequestMapping("/getJson")
    public String getJson() throws  JsonProcessingException{
        UserModel userModel = new UserModel();
        userModel.setPassWord("11");
        userModel.setId(1);

        userModel.setPerson(new Person("123","123",new Date()));
        userModel.setUser(new User("456","456"));
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        om.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        System.out.println(om.writeValueAsString(userModel));
        System.out.println(userModel.isYyyy());
        System.out.println("hannah's");
        System.out.println("hannah'ss");
        return om.writeValueAsString(userModel);
    }




}
