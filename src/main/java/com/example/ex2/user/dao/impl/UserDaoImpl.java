package com.example.ex2.user.dao.impl;

import com.example.ex2.datasource.Database;
import com.example.ex2.shared.UserBean;
import com.example.ex2.user.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public String getUserDetail(UserBean userBean) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Database.getDataSource().getConnection();
            ps = con.prepareStatement("SELECT first_name AS name FROM user WHERE id = ? ");
            ps.setString(1,userBean.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            } else {
                return "NOT FOUND";
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }finally {
            if (con != null) con.close();
            if (ps != null) ps.close();
            if (rs != null) rs.close();
        }
        return "Something wrong";
    }

    @Override
    public String createUser(UserBean userBean) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getDataSource().getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement("INSERT INTO user (first_name,last_name, email, tell) VALUES (?,?,?,?)");
            ps.setString(1, userBean.getFirstName());
            ps.setString(2, userBean.getLastName());
            ps.setString(3, userBean.getEmail());
            ps.setString(4, userBean.getTell());
            ps.execute();
            con.commit();
        } catch (Exception exception) {
            System.out.println(exception);
            if(con!=null) con.rollback();
            return "Something Wrong";
        }finally {
            if (con != null) con.close();
            if (ps != null) ps.close();
        }
        return "Create User Successfully";
    }


    @Override
    public String updateUserDetail(UserBean userBean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getDataSource().getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement("UPDATE user SET first_name = ?, last_name = ? WHERE id = ?");
            ps.setString(1, userBean.getFirstName());
            ps.setString(2, userBean.getLastName());
            ps.setString(3, userBean.getId());
            ps.execute();
            con.commit();
        } catch (Exception exception) {
            System.out.println(exception);
            if(con!=null) con.rollback();
            return "Something wrong";
        }finally {
            if(con!=null) con.close();
            if(ps!=null) ps.close();
        }
        return "Update User Successfully";
    }

    @Override
    public String deleteUser(UserBean userBean) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getDataSource().getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement("DELETE FROM user WHERE id = ?");
            ps.setString(1, userBean.getId());
            ps.execute();
            con.commit();
        } catch (Exception exception) {
            System.out.println(exception);
            if(con!=null) con.rollback();
            return "Something Wrong";
        }finally {
            if(con!=null) con.close();
            if(ps !=null) ps.close();
        }
        return "Delete User Successfully";
    }

    @Override
    public UserBean getUserById(String id) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Database.getDataSource().getConnection();
            ps = con.prepareStatement("SELECT id, first_name, last_name, email, tell FROM user WHERE id = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new UserBean(rs.getString("id"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("email"), rs.getString("tell"));
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }finally {
            if(con!=null) con.close();
            if(ps!=null) ps.close();
            if(rs!=null) rs.close();
        }
        return null;
    }

    @Override
    public List<UserBean> getAllUser() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserBean> userBeans = null;
        try {
            con = Database.getDataSource().getConnection();
            ps = con.prepareStatement("SELECT id, first_name, last_name, email, tell FROM user");
            rs = ps.executeQuery();
            userBeans = new ArrayList<>();
            while (rs.next()) {
                userBeans.add(new UserBean(rs.getString("id"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("email"),
                        rs.getString("tell")));
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }finally {
            if(con!=null) con.close();
            if(ps!=null) ps.close();
            if(rs!=null) rs.close();
        }
        return userBeans;
    }
}
