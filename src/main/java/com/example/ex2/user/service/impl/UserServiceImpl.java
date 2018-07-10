package com.example.ex2.user.service.impl;

import com.example.ex2.shared.UserBean;
import com.example.ex2.user.dao.UserDao;
import com.example.ex2.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String getUserDetail(UserBean userBean) throws SQLException {
        return userDao.getUserDetail(userBean);
    }

    @Override
    public String createUser(UserBean userBean) throws SQLException{
        return userDao.createUser(userBean);
    }

    @Override
    public String updateUserDetail(UserBean userBean) throws SQLException {
        return userDao.updateUserDetail(userBean);
    }

    @Override
    public String deleteUser(UserBean userBean) throws SQLException {
        return userDao.deleteUser(userBean);
    }

    @Override
    public UserBean getUserById(String id) throws SQLException {
        return userDao.getUserById(id);
    }

    @Override
    public List<UserBean> getAllUser() throws SQLException {
        return userDao.getAllUser();
    }
}


