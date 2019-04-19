package main.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {


    public ResultSet query(String sql) {
        Connect connect = new Connect();
        Connection connection = connect.getConnect();
        Statement statement = connect.getStatement(connection);
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("查询失败！");
        }

        return rs;
    }

    public String queryNameById(ResultSet resultSet) throws SQLException {
        String name=null;
        while (resultSet.next()) {
            try {
                name=resultSet.getString("name");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

}
