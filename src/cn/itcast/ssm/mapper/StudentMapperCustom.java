package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.StudentCustom;
import cn.itcast.ssm.po.StudentQueryVo;

public interface StudentMapperCustom {
    //�û���½�ж�
    public StudentCustom findStudentExist(StudentCustom studentCustom)throws Exception;

    void backoutidentity(Integer comid);
}
