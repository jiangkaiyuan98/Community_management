package cn.itcast.ssm.po;

import java.util.List;

public class StudentQueryVo {

    Student student;
    StudentCustom studentCustom;

    //学生参加的社团List
    List<Community> CommunityList;

    public List<Community> getCommunityList() {
        return CommunityList;
    }

    public void setCommunityList(List<Community> communityList) {
        CommunityList = communityList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentCustom getStudentCustom() {
        return studentCustom;
    }

    public void setStudentCustom(StudentCustom studentCustom) {
        this.studentCustom = studentCustom;
    }
}
