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
        String sql = "select name from subject";
        Query query = new Query();
        ResultSet resultSet = query.query(sql);
        List<Subject> subjectList = new ArrayList<>();
        String subjectName = null;
        while (resultSet.next()) {
            try {
                subjectName = resultSet.getString("name");
                subjectList.add(getSubject(subjectName));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return subjectList;
    }


    public String getSubjectName(int subjectId) throws SQLException {
        String sql = "select name from subject where subject_id=\"" + subjectId + "\"";
        Query query = new Query();
        ResultSet resultSet = query.query(sql);
        String subjectName = null;
        subjectName = query.queryNameById(resultSet);

        return subjectName;
    }

    public Subject getSubject(String subjectName) throws SQLException {
        String sql = "select*from subject where name=\"" + subjectName + "\"";
        Query query = new Query();
        ResultSet resultSet = query.query(sql);
        int subjectId = 0;
        int teacherId = 0;
        String teacherName = null;

        while (resultSet.next()) {
            try {
                subjectId = resultSet.getInt("subject_id");
                teacherId = resultSet.getInt("teacher_id");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        TeacherDao teacherDao = new TeacherDao();
        teacherName = teacherDao.getTeacherName(teacherId);
        Subject subject = new Subject();
        subject.setName(subjectName);
        subject.setsubjectId(subjectId);
        subject.setteacherName(teacherName);


        return subject;
    }

    public void addSubjectInfo(String subjectInfo) throws SQLException {
        int subjectID=Integer.valueOf(subjectInfo.split(",")[0]);
        String name=subjectInfo.split(",")[1];
        String teacherName=subjectInfo.split(",")[2];
        TeacherDao teacherDao=new TeacherDao();
        int teacherId=teacherDao.getTeacher(teacherName).getTeacherId();
        String sql="insert into subject values('"+subjectID+"','"+name+"','"+teacherId+"')";
        Update update=new Update();
        if(update.update(sql)!=0);
        System.out.println("成功");
    }

    public void alterSubjectInfo(String subjectInfo) throws SQLException {
        int subjectId=Integer.valueOf(subjectInfo.split(",")[0]);
        String name=subjectInfo.split(",")[1];
        String teacherName=subjectInfo.split(",")[2];
        TeacherDao teacherDao=new TeacherDao();
        int teacherId=teacherDao.getTeacher(teacherName).getTeacherId();
        String sql="update subject set name='"+name+"',teacher_id='"+teacherId+"' where subject_id='"+subjectId+"'";
        Update update=new Update();
        if(update.update(sql)!=0) {
            System.out.println("修改成功！");
        }
    }

    public void deleSubject(String subjectName) {
        String sql="delete from subject where name='"+subjectName+"'";
        Update update=new Update();
        update.update(sql);
    }
}

