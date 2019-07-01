package com.qf.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Consumer;
import com.qf.entity.Email;
import com.qf.service.IConcuserService;
import com.qf.service.IEamilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.resource.HttpResource;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("/consumer")
public class ConsumerController {

    @Reference
    private IEamilService eamilService;

    @Reference
    private IConcuserService concuserService;

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/toEmail")
    public String toEmail(@RequestBody String email, HttpSession session){
        Random random = new Random(10);
        String number = null ;
        for(int i=0;i<4;i++){
            number += random.nextInt()+"";
        }
        session.setAttribute("number",number);
        Email email2 = new Email();
        email2.setTo("1324354@qq.com");
        email2.setSubject("你的验证码信息");
        email2.setText(number);
        email2.setTime(new Date());
        eamilService.sendEmail(email2);
        return "请注意查看邮件";
    }

    @RequestMapping("/register")
    public String register(Consumer consumer, HttpServletResponse response) throws IOException {
        int result = concuserService.register(consumer);
        if(result>0){
            try {
                 response.getWriter().write("注册成功"+"<a href='/consumer/toLogin'>登录<a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        response.getWriter().write("注册失败，请重新注册");
        return "register";
    }

    @RequestMapping("/login")
    public String login(String name,String password){
        int result = concuserService.queryByNameAndPassword(name,password);
        if(result>0){
            return "page";
        }
        return  "login";
    }


    @RequestMapping("/toForget")
    public String toForget(){
      return "forget";
    }

    @RequestMapping("/findEmail")
    public String findEmail(String name){

        return null;

    }


}
