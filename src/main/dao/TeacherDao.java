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

    public void addTeacherInfo(String teacherInfo) throws SQLException {
        SubjectDao subjectDao=new SubjectDao();
        int teacherId=Integer.valueOf(teacherInfo.split(",")[0]);
        String name=teacherInfo.split(",")[1];
        String sex=teacherInfo.split(",")[2];
        String subject=teacherInfo.split(",")[3];
        int subjectId=subjectDao.getSubject(subject).getsubjectId();
        UserDao userDao=new UserDao();
        int userId=userDao.addUser(name,2);
        String sql="insert into teacher values('"+userId+"','"+teacherId+"','"+name+"','"+sex+"','"+subjectId+"')";
        Update update=new Update();
        int line=0;
        if(update.update(sql)!=0);
        System.out.println("成功新增"+name);
    }

    public void alterTeacherInfo(String teacherInfo) throws SQLException {
        int teacherId=Integer.valueOf(teacherInfo.split(",")[0]);
        String name=teacherInfo.split(",")[1];
        String sex=teacherInfo.split(",")[2];
        String subjectName=teacherInfo.split(",")[2];
        SubjectDao subjectDao=new SubjectDao();
        int subjectId=subjectDao.getSubject(subjectName).getsubjectId();
        String sql="update teacher set name='"+name+"',sex='"+sex+"',subject_id='"+subjectId+"' where teacher_id='"+teacherId+"'";
        Update update=new Update();
        if(update.update(sql)!=0) {
            System.out.println("修改成功！");
        }
    }

    public void deleTeacher(String teacherId) throws SQLException {
        String sql1="select*from teacher where teacher_id='"+teacherId+"'";
        Query query=new Query();
        ResultSet resultSet=query.query(sql1);
        String teacherName=query.queryNameById(resultSet);
        Teacher teacher=getTeacher(teacherName);
        int userId=teacher.getUserId();
        UserDao userDao=new UserDao();
        userDao.deleUser(userId);
        String sql="delete from teacher where teacher_id='"+teacherId+"'";
        Update update=new Update();
        update.update(sql);
        System.out.println("删除老师["+teacherName+","+teacherId+"]成功！");
    }
}



