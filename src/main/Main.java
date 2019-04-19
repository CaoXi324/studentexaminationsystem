package main;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import main.dao.ScoreDao;
import main.dao.StudentDao;
import main.dao.SubjectDao;
import main.dao.TeacherDao;
import main.module.*;
import main.service.Service;
import main.service.UserService;
import main.tools.Input;
import main.tools.Print;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Note note = new Note();
        Input input = new Input();
        UserService userService = new UserService();
        StudentDao studentDao = new StudentDao();
        TeacherDao teacherDao = new TeacherDao();
        SubjectDao subjectDao = new SubjectDao();
        ScoreDao scoreDao = new ScoreDao();
        Print print = new Print();
        boolean loginSuccess;
        do {
            System.out.println(note.getWELCOMENOTE());
            String accountInfo = input.getInput();
            String userName = accountInfo.split(":")[0];
            String password = accountInfo.split(":")[1];
            loginSuccess = userService.login(userName, password);
        } while (!loginSuccess);

        System.out.println(note.getMAININTERFACE());

        String number = input.getNumber();
        switch (number) {
            case "1.1.1":
                List<Student> studentList = studentDao.getAllStudent();
                for (int i = 0; i < studentList.size(); i++) {
                    print.printStudentInfoAndScore(studentList.get(i));
                }
                break;
            case "1.1.2":
                System.out.println(note.getQUERYSTUDENTINFOANDSCORE());
                String studentName = input.getInput();
                Student student = studentDao.getStudent(studentName);
                print.printStudentInfoAndScore(student);
                break;
            case "1.1.3":
                System.out.println(note.getQUERYSTUDENTANDSCOREBYTEACHER());
                String teacherName = input.getInput();
                Teacher teacher = teacherDao.getTeacher(teacherName);
                Subject subject = teacher.getSubject();
                List<Score> scoreList = scoreDao.getSubjectScore(subject);
                print.printSubjectScore(scoreList);

                break;
            case "1.1.4":
                System.out.println(note.getQUERYSTUDENTANDSCOREBYSUBJECT());
                String subjectName = input.getInput();
                Subject subject1 = subjectDao.getSubject(subjectName);
                List<Score> scoreList1 = scoreDao.getSubjectScore(subject1);
                print.printSubjectScore(scoreList1);

                break;
            case "1.2.1":
                List<Subject> subjectList = subjectDao.getAllSubject();
                for (int i = 0; i < subjectList.size(); i++) {
                    print.printSubjectInfo(subjectList.get(i));
                }
                break;
            case "1.2.2":
                System.out.println(note.getQUERYSUBJECTINFO());
                String subject2 = input.getInput();
                print.printSubjectInfo(subjectDao.getSubject(subject2));
                break;
            case "1.2.3":
                System.out.println(note.getQUERYTEACHERSUBJECTINFOBYTEACHER());
                String teacherName1 = input.getInput();
                Teacher teacher2 = teacherDao.getTeacher(teacherName1);
                print.printSubjectInfo(teacher2.getSubject());
                break;
            case "1.3.1":
                List<Teacher> teacherList = teacherDao.getAllTeacher();
                for (int i = 0; i < teacherList.size(); i++) {
                    print.printTeacherInfo(teacherList.get(i));
                }
                break;
            case "1.3.2":
                System.out.println(note.getQUARYTEACHERINFO());
                String teacherName2=input.getInput();
                Teacher teacher3=teacherDao.getTeacher(teacherName2);
                print.printTeacherInfo(teacher3);
                break;
            case "2.1":
                System.out.println(note.INPUTSTUDENTINFO);
                String studentInfo=input.getInput();
                List<String> stringList= Arrays.asList(studentInfo);



        }

    }
}
