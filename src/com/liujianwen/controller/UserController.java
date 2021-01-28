package com.liujianwen.controller;

import com.liujianwen.annotation.CustomAutoware;
import com.liujianwen.service.IUserService;
import com.liujianwen.service.impl.UserServiceImpl;

public class UserController {

    @CustomAutoware
    private UserServiceImpl userService;

    public void test(){
        userService.test();
    }
}
