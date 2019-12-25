package cn.itcast.ssm.po;

import java.util.List;

public class JoinActivityMembersQueryVo {
    private JoinActivityMembers joinActivityMembers;
    private List<JoinActivityMembers> joinActivityMembersList;
    private List<StudentCustom> studentCustomList;

    public List<StudentCustom> getStudentCustomList() {
        return studentCustomList;
    }

    public void setStudentCustomList(List<StudentCustom> studentCustomList) {
        this.studentCustomList = studentCustomList;
    }

    public JoinActivityMembers getJoinActivityMembers() {
        return joinActivityMembers;
    }

    public void setJoinActivityMembers(JoinActivityMembers joinActivityMembers) {
        this.joinActivityMembers = joinActivityMembers;
    }

    public List<JoinActivityMembers> getJoinActivityMembersList() {
        return joinActivityMembersList;
    }

    public void setJoinActivityMembersList(List<JoinActivityMembers> joinActivityMembersList) {
        this.joinActivityMembersList = joinActivityMembersList;
    }

}
