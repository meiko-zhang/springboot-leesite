package com.meiko.leesite.demo.controller;


import com.meiko.leesite.demo.domain.User;
import com.meiko.leesite.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户模块
 * </p>
 *
 * @author meiko-zahng
 * @since 2018-12-08
 */
@Api(value = "user", tags = "用户模块")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userServiceImpl;

    @ApiOperation(value = "helloworld", notes = "测试方法")
    @GetMapping("/")
    public String hello() {
        return "helloworld!!!";
    }

    @ApiOperation(value = "获取全部用户", notes = "查询全部用户")
    @GetMapping("/list")
    public List<User> findAll() {
        return userServiceImpl.list();
    }

}

