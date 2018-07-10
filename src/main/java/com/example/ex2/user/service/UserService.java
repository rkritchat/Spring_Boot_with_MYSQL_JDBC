package com.example.ex2.user.service;

import com.example.ex2.shared.UserBean;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    String getUserDetail(UserBean userBean) throws SQLException;

    String createUser(UserBean userBean) throws SQLException;

    String updateUserDetail(UserBean userBean) throws SQLException;

    String deleteUser(UserBean userBean) throws SQLException;

    UserBean getUserById(String id) throws SQLException;

    List<UserBean> getAllUser() throws SQLException;
}
