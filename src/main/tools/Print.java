package main.tools;

import main.dao.Query;
import main.dao.StudentDao;
import main.module.Score;
import main.module.Student;
import main.module.Subject;
import main.module.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Print {
    public void printStudentInfoAndScore(Student student) {
        List<Score> scoreList = student.getScoreList();
        String scoreString =new String();
        String subject=null;
        int point=0;
        for (int i = 0; i < scoreList.size(); i++) {
            subject = scoreList.get(i).getsubjectName();
            point = scoreList.get(i).getPoint();
            scoreString=scoreString.concat(subject).concat(":").concat(String.valueOf(point)).concat(",");
        }
        System.out.println("学生姓名：" + student.getName() + ", 学号：" + student.getStudentId() +
                ", 性别：" + student.getSex() +","+ scoreString);
    }

    public void printSubjectInfo(Subject subject) {
        int subjectId = subject.getsubjectId();
        String subjectName = subject.getName();
        String subjectTeacherName = subject.getteacherName();
        System.out.println("课程ID：" + subjectId + ",课程名称：" + subjectName + ",任课教师：" + subjectTeacherName);
    }

    public void printTeacherInfo(Teacher teacher) {
        int teacherId=teacher.getTeacherId();
        String teacherName=teacher.getName();
        String sex=teacher.getSex();
        String subject=teacher.getSubject().getName();
        System.out.println("教师姓名："+teacherName+",教师ID："+teacherId+",性别："+sex+":教授课程:"+subject);
    }

    public void printSubjectScore(List<Score> scoreList) throws SQLException {
        StudentDao studentDao=new StudentDao();
        for (int i=0;i<scoreList.size();i++) {
            int studentId=scoreList.get(i).getStudentId();
            String sql="select*from student where student_id=\""+studentId+"\"";
            Query query=new Query();
            ResultSet resultSet=query.query(sql);
            String studentName=query.queryNameById(resultSet);
            System.out.println("学生姓名："+studentName+",成绩："+scoreList.get(i).getPoint());
        }
    }
}
