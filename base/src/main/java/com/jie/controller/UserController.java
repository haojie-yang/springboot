package com.jie.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;

/**
 * @description:
 * @author: yanghaojie 31648
 * @date: 2020/8/7 17:18
 */
@RequestMapping("/login")
@RestController
@CrossOrigin
public class UserController {

    @RequestMapping("/login")
    public ModelAndView loginForm(ModelAndView modelAndView){
        modelAndView.setViewName("login/login");
        return modelAndView;
    }
}
