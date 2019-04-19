package main.dao;

import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    public int update(Statement statement, String sql) {
        int line = 0;
        try {
            line = statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("操作失败！");
        }

        return line;
    }
}

