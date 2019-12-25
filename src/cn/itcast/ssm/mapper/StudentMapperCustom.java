package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.StudentCustom;
import cn.itcast.ssm.po.StudentQueryVo;

public interface StudentMapperCustom {
    //ÓÃ»§µÇÂ½ÅÐ¶Ï
    public StudentCustom findStudentExist(StudentCustom studentCustom)throws Exception;

    void backoutidentity(Integer comid);
}
