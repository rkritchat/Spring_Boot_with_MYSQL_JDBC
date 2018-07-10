package com.example.ex2.user;

import com.example.ex2.shared.UserBean;
import com.example.ex2.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Address -> /user/detail
     * @param userBean
     * @throws SQLException
     */
    @PostMapping("/detail")
    public String getUserDetail(@RequestBody UserBean userBean) throws SQLException {
        return userService.getUserDetail(userBean);
    }

    /**
     * Address -> /user/create
     * @param userBean
     * @throws SQLException
     */
    @PutMapping("/create")
    public String createUser(@RequestBody UserBean userBean) throws SQLException {
        return userService.createUser(userBean);
    }

    /**
     * Address -> /user/update
     * @param userBean
     * @throws SQLException
     */
    @PatchMapping("/update")
    public String updateUser(@RequestBody UserBean userBean) throws SQLException {
        return userService.updateUserDetail(userBean);
    }

    /**
     * Address -> /user/delete
     * @param userBean
     * @throws SQLException
     */
    @DeleteMapping("/delete")
    public String deleteUser(@RequestBody UserBean userBean) throws SQLException {
        return userService.deleteUser(userBean);
    }

    /**
     * Address -> /user?id=1
     * @param id
     * @throws SQLException
     */
    @GetMapping
    public UserBean getUserById(@RequestParam String id) throws SQLException{
        return userService.getUserById(id);
    }

    /**
     * Address ->  /user/all
     * @throws SQLException
     */
    @GetMapping("/all")
    public List<UserBean> getAllUser() throws SQLException{
        return userService.getAllUser();
    }
}
