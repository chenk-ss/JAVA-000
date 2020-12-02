package com.chenk.abstractroutingdatasource.service;

import com.chenk.abstractroutingdatasource.dataaccess.annotation.DataSource;
import com.chenk.abstractroutingdatasource.dataaccess.common.ContextConst;
import com.chenk.abstractroutingdatasource.pojo.User;
import com.chenk.abstractroutingdatasource.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author chenk
 * @create 2020/12/2 20:30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> queryAll() {
        return userRepository.findAll();
    }

    @Override
    @DataSource(ContextConst.DataSourceType.MASTER)
    public User add(User user) {
        return userRepository.save(user);
    }
}
