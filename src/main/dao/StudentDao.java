package main.dao;

import main.module.Score;
import main.module.Student;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public List<Student> getAllStudent() throws SQLException {
        String sql="select name from student;";
        Query query=new Query();
        ResultSet resultSet=query.query(sql);
        List<Student> studentList=new ArrayList<>();
        String studentName=null;
        while (resultSet.next()) {
            try{
                studentName=resultSet.getString("name");
                studentList.add(getStudent(studentName));
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return studentList;

    }
    public Student getStudent(String studentName) throws SQLException {
        String sql = "select user_id,student_id,sex from student where name=\"" + studentName + "\"";
        Query query = new Query();
        ResultSet resultSet = query.query(sql);
        int userId = 0;
        int studentId = 0;
        String sex = null;

        while (resultSet.next()) {

            try {
                userId = resultSet.getInt("user_id");
                studentId = resultSet.getInt("student_id");
                sex = resultSet.getString("sex");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ao");
            }
        }


        Student student = new Student();
        ScoreDao scoreDao=new ScoreDao();
        List<Score> scoreList=scoreDao.getScore(studentId);
        student.setName(studentName);
        student.setSex(sex);
        student.setStudentId(studentId);
        student.setUserId(userId);
        student.setScoreList(scoreList);


        return student;
    }
}

