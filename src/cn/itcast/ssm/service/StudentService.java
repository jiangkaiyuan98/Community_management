package cn.itcast.ssm.service;

import cn.itcast.ssm.po.StudentCustom;

public interface StudentService {
    StudentCustom findStudentExist(StudentCustom studentCustom)throws Exception;
    StudentCustom findStudentById(Integer id)throws Exception;
    void updataStudent(StudentCustom studentCustom)throws Exception;

    void backoutidentity(Integer comid);

    void uptoidentity(Integer stuid);
}
