package com.dk.service;

import com.dk.dao.UserDao;
import com.dk.domain.User;

public class UserService {
    UserDao ud = new UserDao();
    public int loginCheck(String username, String password) {
        return ud.loginCheck(username,password);
    }

    public int usernameIsExist(String username) {
        return ud.usernameIsExist(username);
    }

    public int registIt(User user) {
        return ud.regist(user);
    }
}