package main.dao;

import main.module.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDao {
    public Role getRole(int roleId) throws SQLException {
        String sql="select role_name from role where role_id=\""+roleId+"\"";
        Query query=new Query();
        ResultSet resultSet=query.query(sql);
        String roleName=null;
        while (resultSet.next()) {
            try {

                roleName=resultSet.getString("role_name");
            } catch(SQLException e) {
                e.printStackTrace();

            }
        }
        Role role=new Role();
        role.setRoleId(roleId);
        role.setRoleName(roleName);
        return role;

    }
}
