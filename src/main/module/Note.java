package main.module;

public class Note {
    public final String WELCOMENOTE =
            "您好，欢迎登陆学生考试系统，请输入您的用户名和密码(用户名:密码)：\n" +
                    "例如：张三:123";
    public final String MAININTERFACE =
            "您好，超级管理员，请选择你需要进行的操作：\n" +
                    "1. 查询\n" +
                    "\t1.1 查询学生信息以及成绩\n" +
                    "\t\t1.1.1 所有学生信息\n" +
                    "\t\t1.1.2 指定学生姓名的信息以及所有课程的成绩\n" +
                    "\t\t1.1.3 指定老师的所有学生及其成绩\n" +
                    "\t\t1.1.4 指定课程的所有学生及其成绩\n" +
                    "\t1.2 查询课程信息\n" +
                    "\t\t1.2.1 所有课程信息\n" +
                    "\t\t1.2.2 指定课程名称的信息\n" +
                    "\t\t1.2.3 指定老师的所有课程信息\n" +
                    "\t1.3 查询老师信息\n" +
                    "\t\t1.3.1 所有老师信息\n" +
                    "\t\t1.3.2 指定老师信息\n" +
                    "2. 新增\n" +
                    "\t2.1 新增学生信息\n" +
                    "\t2.2 新增课程信息\n" +
                    "\t2.3 新增老师信息\n" +
                    "\t2.4 给指定学生新增成绩\n" +
                    "3. 修改\n" +
                    "\t3.1 修改指定学号的学生\n" +
                    "\t3.2 修改指定课程的信息\n" +
                    "\t3.3 修改指定老师的信息\n" +
                    "\t3.4 修改指定学生的成绩\n" +
                    "4. 删除\n" +
                    "\t4.1 删除指定学生\n" +
                    "\t4.3 删除指定课程\n" +
                    "\t4.3 删除指定老师";
    public final String INPUTSTUDENTINFO =
            "请输入学生信息(例如：学号：1001，姓名： 小明, 性别： 男)：";
    public final String INPUTTERCHER=
            "请输入老师信息(例如：工号：2001，姓名：王老师, 所教课程：语文)：";
    public final String INPUTSUBJECT=
            "请输入课程信息(例如：课程id：3001，课程名称：语文, 任课老师：王老师)：";
    public final String ADDSTUDENTSCORE=
            "请输入新增成绩信息(例如：学生姓名：小明，课程名称：语文, 分数：100)：";
    public final String ALTERSTUDENTBYID=
            "请输入要修改的学生信息(例如：学号：1001，姓名： 小明, 年龄： 18, 性别： 男)：";
    public final String ALTERSUBJECTINFO=
            "请输入要修改的课程信息(例如：课程id：3001，课程名称：语文, 任课老师：王老师)：";
    public final String ALTERTEACHERINFO=
            "请输入要修改的老师信息(例如：工号：2001，姓名：王老师, 性别： 男, 所教课程：语文)：";
    public final String ALTERSTUDENTSCORE=
            "请输入要修改的成绩信息(例如：学生姓名：小明，课程名称：语文, 分数：100)：";
    public final String DELETESTUDENTNOTE =
            "删除学生之后，该学生信息将不能恢复，是否要继续删除？\n" +
                    "1. 是\n" +
                    "2. 否";
    public final String DELETESTUDENTID=
            "请输入您需要删除的学生学号：";
    public final String DELETESUBJECTNOTE =
            "删除课程之后，该课程信息将不能恢复，是否要继续删除？\n" +
                    "1. 是\n" +
                    "2. 否";
    public final String DELETESUBJECTID=
            "请输入您需要删除的课程：";
    public final String DELETETEACHERNOTE =
            "删除老师之后，该老师信息将不能恢复，是否要继续删除？\n" +
                    "1. 是\n" +
                    "2. 否";
    public final String DELETETEACHERID=
            "请输入您需要删除的老师id：";
    public final String QUERYSTUDENTINFOANDSCORE=
            "请输入要查询信息及成绩的学生姓名：";
    public final String QUERYSTUDENTANDSCOREBYTEACHER=
            "请输入要查询学生和成绩的老师姓名：";
    public final String QUERYSTUDENTANDSCOREBYSUBJECT=
            "请输入要查询学生和成绩的课程名称：";
    public final String QUERYSUBJECTINFO=
            "请输入要查询的课程名称：";
    public final String QUERYTEACHERSUBJECTINFOBYTEACHER=
            "请输入要查询课程的任课老师姓名：";
    public final String QUARYTEACHERINFO=
            "请输入要查询的老师姓名：";
    public String getWELCOMENOTE() {
        return WELCOMENOTE;
    }

    public String getADDSTUDENTSCORE() {
        return ADDSTUDENTSCORE;
    }

    public String getALTERSTUDENTBYID() {
        return ALTERSTUDENTBYID;
    }

    public String getALTERSTUDENTSCORE() {
        return ALTERSTUDENTSCORE;
    }

    public String getALTERSUBJECTINFO() {
        return ALTERSUBJECTINFO;
    }

    public String getALTERTEACHERINFO() {
        return ALTERTEACHERINFO;
    }

    public String getINPUTSTUDENTINFO() {
        return INPUTSTUDENTINFO;
    }

    public String getDELETESTUDENTID() {
        return DELETESTUDENTID;
    }

    public String getDELETESTUDENTNOTE() {
        return DELETESTUDENTNOTE;
    }

    public String getINPUTSUBJECT() {
        return INPUTSUBJECT;
    }

    public String getDELETESUBJECTID() {
        return DELETESUBJECTID;
    }

    public String getDELETESUBJECTNOTE() {
         return DELETESUBJECTNOTE;
    }

    public String getINPUTTERCHER() {
        return INPUTTERCHER;
    }

    public String getDELETETEACHERID() {
        return DELETETEACHERID;
    }

    public String getMAININTERFACE() {
        return MAININTERFACE;
    }

    public String getDELETETEACHERNOTE() {
        return DELETETEACHERNOTE;
    }

    public String getQUERYSTUDENTANDSCOREBYSUBJECT() {
        return QUERYSTUDENTANDSCOREBYSUBJECT;
    }

    public String getQUERYSTUDENTINFOANDSCORE() {
        return QUERYSTUDENTINFOANDSCORE;
    }

    public String getQUARYTEACHERINFO() {
        return QUARYTEACHERINFO;
    }

    public String getQUERYSTUDENTANDSCOREBYTEACHER() {
        return QUERYSTUDENTANDSCOREBYTEACHER;
    }

    public String getQUERYSUBJECTINFO() {
        return QUERYSUBJECTINFO;
    }

    public String getQUERYTEACHERSUBJECTINFOBYTEACHER() {
        return QUERYTEACHERSUBJECTINFOBYTEACHER;
    }
}
