package com.meiko.leesite.demo.service.impl;

import com.meiko.leesite.demo.domain.User;
import com.meiko.leesite.demo.mapper.UserMapper;
import com.meiko.leesite.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author meiko-zahng
 * @since 2018-12-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
