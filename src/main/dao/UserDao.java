package main.dao;

import main.module.Role;
import main.module.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User getUser(String userName, String password) throws SQLException {
        String sql = "select user_id,role_id from user where user_name=\"" + userName + "\"" + "and user_password=\"" + password + "\"";
        Query query = new Query();
        ResultSet resultSet = query.query(sql);
        int userId = 0;
        int roleId = 0;

        while (resultSet.next()){

            try {
                userId = resultSet.getInt("user_id");
                roleId = resultSet.getInt("role_id");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ao");
            }
        }
            RoleDao roleDao = new RoleDao();
            Role role = roleDao.getRole(roleId);
            User user = new User();
            user.setPassword(password);
            user.setRole(role);
            user.setUserId(userId);
            user.setUserName(userName);
            return user;
        }
    }
