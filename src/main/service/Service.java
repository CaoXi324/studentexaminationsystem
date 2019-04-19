package main.service;

import main.dao.Connect;
import main.tools.Input;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Service {
    public static Connect connect = new Connect();
    public static Connection connection = connect.getConnect();
    public static Statement statement = connect.getStatement(connection);
    Input input=new Input();

    public void showInterface() {
        System.out.println();
    }

    public void isManager(String inputString) {
        String account = inputString.split(",")[0];
        String password = inputString.split(",")[1];
        String querySQL = "SELECT*FROM manager where account=\"" + account +"\""+"and password= \""+ password+"\"";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(querySQL);
            System.out.println(rs.toString());
        } catch (SQLException e) {
            System.out.println("请输入正确的账号密码！");
            input.getInput();


        }
    }



    }




