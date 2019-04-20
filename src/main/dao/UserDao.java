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

        while (resultSet.next()) {

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

    public int addUser(String userName, int roleId) throws SQLException {
        String sql = "insert into user values(0,'" + userName + "','000','" + roleId + "')";
        Update update = new Update();
        update.update(sql);
        String sql2 = "select max(user_id) from user";
        Query query = new Query();
        ResultSet resultSet = query.query(sql2);
        int userId = 0;
        while (resultSet.next()) {
            try {
                userId = resultSet.getInt("max(user_id)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userId;
    }

    public void deleUser(int userId) {
        String sql="delete from user where user_id='"+userId+"'";
        Update update=new Update();
        update.update(sql);

    }
}
