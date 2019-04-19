package main.module;

public class Teacher  {
    private int userId;
    private int teacherId;
    private String name;
    private String sex;
    private Subject subject;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public String getName() {
        return name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getSex() {
        return sex;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
