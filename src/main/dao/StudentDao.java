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

    public void addStudentInfo(String studentInfo) throws SQLException {
        int studentId=Integer.valueOf(studentInfo.split(",")[0]);
        String name=studentInfo.split(",")[1];
        String sex=studentInfo.split(",")[2];
        UserDao userDao=new UserDao();
        int userId=userDao.addUser(name,1);
        String sql="insert into student values('"+userId+"','"+studentId+"','"+name+"','"+sex+"')";
        Update update=new Update();
        int line=0;
        line=update.update(sql);
        System.out.println(line);
    }

    public void alterStudentInfo(String studentInfo) throws SQLException {
        int studentId=Integer.valueOf(studentInfo.split(",")[0]);
        String name=studentInfo.split(",")[1];
        String sex=studentInfo.split(",")[2];
        String sql="update student set name='"+name+"',sex='"+sex+"' where student_id='"+studentId+"'";
        Update update=new Update();
        if(update.update(sql)!=0) {
            System.out.println("修改成功！");
        }
    }

    public void deleStudent(String studentId) throws SQLException {
        String sql1="select*from student where student_id='"+studentId+"'";
        Query query=new Query();
        ResultSet resultSet=query.query(sql1);
        String studentName=query.queryNameById(resultSet);
        StudentDao studentDao=new StudentDao();
        int userId=studentDao.getStudent(studentName).getUserId();
        UserDao userDao=new UserDao();
        userDao.deleUser(userId);
        String sql="delete from student where student_id='"+studentId+"'";
        Update update=new Update();
        update.update(sql);
        System.out.println("删除学生["+studentName+"，学号："+studentId+"]成功！");
    }
}


