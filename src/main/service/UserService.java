package main.service;

import main.dao.UserDao;
import main.module.User;

import java.sql.SQLException;

public class UserService {
    public boolean login(String userName,String password) throws SQLException {
        UserDao userDao=new UserDao();
        User user=userDao.getUser(userName,password);
        return user!=null;
    }
}
