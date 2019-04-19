package main.dao;

import main.module.Role;
import main.module.Subject;
import main.module.Teacher;
import main.module.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {

    public List<Teacher> getAllTeacher() throws SQLException {
        String sql="select name from teacher;";
        Query query=new Query();
        ResultSet resultSet=query.query(sql);
        List<Teacher> teacherList=new ArrayList<>();
        String teacherName=null;
        while (resultSet.next()) {
            try{
                teacherName=resultSet.getString("name");
                teacherList.add(getTeacher(teacherName));
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return teacherList;

    }

    public String getTeacherName(int teacherId) throws SQLException {
        String sql = "select name from teacher where teacher_id=\"" + teacherId + "\"";
        String teacherName = null;
        Query query = new Query();
        ResultSet resultSet = query.query(sql);
        teacherName = query.queryNameById(resultSet);
        return teacherName;

    }


    public static Teacher getTeacher(String teacherName) throws SQLException {
        String sql = "select*from teacher where name=\"" + teacherName + "\"";
        Query query = new Query();
        ResultSet resultSet = query.query(sql);
        int userId = 0;
        int teacherId = 0;
        int subjectId = 0;
        String sex = null;

        while (resultSet.next()) {

            try {
                userId = resultSet.getInt("user_id");
                teacherId = resultSet.getInt("teacher_id");
                sex = resultSet.getString("sex");
                subjectId = resultSet.getInt("subject_id");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ao");
            }
        }

        SubjectDao subjectDao = new SubjectDao();
        String subjectName = subjectDao.getSubjectName(subjectId);
        Subject subject = subjectDao.getSubject(subjectName);

        Teacher teacher = new Teacher();
        teacher.setName(teacherName);
        teacher.setSex(sex);
        teacher.setTeacherId(teacherId);
        teacher.setUserId(userId);
        teacher.setSubject(subject);

        return teacher;
    }
}



