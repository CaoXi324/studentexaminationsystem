package main;

import main.dao.*;
import main.module.*;
import main.service.UserService;
import main.tools.Input;
import main.tools.Print;

import java.sql.SQLException;
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
        Update update = new Update();
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
                String teacherName2 = input.getInput();
                Teacher teacher3 = teacherDao.getTeacher(teacherName2);
                print.printTeacherInfo(teacher3);
                break;
            case "2.1":
                System.out.println(note.INPUTSTUDENTINFO);
                String studentInfo = input.getInput();
                studentDao.addStudentInfo(studentInfo);
                break;
            case "2.2":
                System.out.println(note.getINPUTSUBJECT());
                String subjectInfo = input.getInput();
                subjectDao.addSubjectInfo(subjectInfo);
                break;
            case "2.3":
                System.out.println(note.getINPUTTERCHER());
                String teacherInfo = input.getInput();
                teacherDao.addTeacherInfo(teacherInfo);
                break;
            case "2.4":
                System.out.println(note.ADDSTUDENTSCORE);
                String score = input.getInput();
                scoreDao.addScore(score);
                break;
            case "3.1":
                System.out.println(note.ALTERSTUDENTBYID);
                String studentInfo1 = input.getInput();
                studentDao.alterStudentInfo(studentInfo1);
                break;
            case "3.2":
                System.out.println(note.ALTERSUBJECTINFO);
                String subjectInfo1 = input.getInput();
                subjectDao.alterSubjectInfo(subjectInfo1);
                break;
            case "3.3":
                System.out.println(note.ALTERTEACHERINFO);
                String teacherInfo1 = input.getInput();
                teacherDao.alterTeacherInfo(teacherInfo1);
                break;
            case "3.4":
                System.out.println(note.ALTERSTUDENTSCORE);
                String score1 = input.getInput();
                scoreDao.alterScore(score1);
                break;
            case "4.1":
                System.out.println(note.DELETESTUDENTNOTE);
                String deleNumber = input.getInput();
                if (deleNumber.equals("1")) {
                    System.out.println(note.DELETESTUDENTID);
                    String studentId = input.getInput();
                    studentDao.deleStudent(studentId);
                }
                break;
            case "4.2":
                System.out.println(note.DELETESUBJECTNOTE);
                String deleNumber1 = input.getInput();
                if (deleNumber1.equals("1")) {
                    System.out.println(note.DELETESUBJECTID);
                    String subjectName1 = input.getInput();
                    subjectDao.deleSubject(subjectName1);
                }
                break;
            case "4.3":
                System.out.println(note.DELETETEACHERNOTE);
                String deleNumber2 = input.getInput();
                if (deleNumber2.equals("1")) {
                    System.out.println(note.DELETETEACHERID);
                    String teacherId = input.getInput();
                    teacherDao.deleTeacher(teacherId);
                }
                break;
        }
    }
}
