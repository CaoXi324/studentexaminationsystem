package main.dao;

import main.module.Score;
import main.module.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreDao {
    public static List<Score> getScore(int studentId) throws SQLException {
        String sql = "select*from score where student_id=\"" + studentId + "\"";
        List<Score> scoreList = getScoreCommon(sql);
        for (int i = 0; i < scoreList.size(); i++) {
            scoreList.get(i).setStudentId(studentId);
        }
        return scoreList;
    }

    public List<Score> getSubjectScore(Subject subject) throws SQLException {
        int subjectId = subject.getsubjectId();
        String sql = "select*from score where subject_id=\"" + subjectId + "\"";
        List<Score> scoreList=getScoreCommon(sql);
        for(int i=0;i<scoreList.size();i++) {
            scoreList.get(i).setsubjectName(subject.getName());
        }

        return scoreList;

    }

    public static List<Score> getScoreCommon(String sql) throws SQLException {
        Query query = new Query();
        ResultSet resultSet = query.query(sql);

        List<Score> scoreList = new ArrayList<>();
        int point = 0;
        int subjectId = 0;
        int scoreId = 0;

        while (resultSet.next()) {
            Score score = new Score();
            try {
                point = resultSet.getInt("point");
                scoreId = resultSet.getInt("score_id");
                subjectId = resultSet.getInt("subject_id");

            } catch (SQLException e) {
                e.printStackTrace();
            }

            String subjectName = new String();
            SubjectDao subjectDao = new SubjectDao();
            subjectName = subjectDao.getSubjectName(subjectId);
            score.setPoint(point);
            score.setScoreId(scoreId);
//            score.setStudentId(studentId);
            score.setsubjectName(subjectName);
            scoreList.add(score);
        }
        return scoreList;

    }

    public void addScore(String score) throws SQLException {
        String studentName=score.split(",")[0];
        String subjectName=score.split(",")[1];
        int point=Integer.valueOf(score.split(",")[2]);
        SubjectDao subjectDao=new SubjectDao();
        StudentDao studentDao=new StudentDao();
        int subjectId=subjectDao.getSubject(subjectName).getsubjectId();
        int studentId=studentDao.getStudent(studentName).getStudentId();
        String sql="insert into score values(0,'"+studentId+"','"+subjectId+"','"+point+"')";
        Update update=new Update();
        update.update(sql);
    }

    public void alterScore(String score) throws SQLException {
        String studentName=score.split(",")[0];
        String subjectName=score.split(",")[1];
        int point=Integer.valueOf(score.split(",")[2]);
        StudentDao studentDao=new StudentDao();
        SubjectDao subjectDao=new SubjectDao();
        int studentId=studentDao.getStudent(studentName).getStudentId();
        int subjectId=subjectDao.getSubject(subjectName).getsubjectId();
        String sql="update score set point='"+point+"' where subject_id=" +
                "'"+subjectId+"' and student_id='"+studentId+"'";
        Update update=new Update();
        update.update(sql);
    }


}
