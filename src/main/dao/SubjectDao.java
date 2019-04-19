package main.dao;

import main.module.Role;
import main.module.Student;
import main.module.Subject;
import main.module.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {

    public List<Subject> getAllSubject() throws SQLException {
        String sql="select name from subject";
        Query query=new Query();
        ResultSet resultSet=query.query(sql);
        List<Subject> subjectList=new ArrayList<>();
        String subjectName=null;
        while (resultSet.next()) {
            try{
                subjectName=resultSet.getString("name");
                subjectList.add(getSubject(subjectName));
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return subjectList;
    }



    public String getSubjectName(int subjectId) throws SQLException {
        String sql="select name from subject where subject_id=\""+subjectId+"\"";
        Query query =new Query();
        ResultSet resultSet=query.query(sql);
        String subjectName=null;
        subjectName=query.queryNameById(resultSet);

        return subjectName;
    }

    public Subject getSubject(String subjectName) throws SQLException {
        String sql = "select*from subject where name=\"" + subjectName+"\"";
        Query query = new Query();
        ResultSet resultSet = query.query(sql);
        int subjectId = 0;
        int teacherId = 0;
        String teacherName=null;

        while (resultSet.next()){
            try {
                subjectId = resultSet.getInt("subject_id");
                teacherId = resultSet.getInt("teacher_id");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        TeacherDao teacherDao=new TeacherDao();
        teacherName=teacherDao.getTeacherName(teacherId);
        Subject subject=new Subject();
        subject.setName(subjectName);
        subject.setsubjectId(subjectId);
        subject.setteacherName(teacherName);


        return subject;
    }
    }

