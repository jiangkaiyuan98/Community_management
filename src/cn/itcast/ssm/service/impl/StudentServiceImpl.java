package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.mapper.*;
import cn.itcast.ssm.po.*;
import cn.itcast.ssm.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapperCustom studentMapperCustom;
    @Autowired
    private  StudentMapper studentMapper;
    public StudentCustom findStudentExist(StudentCustom studentCustom)throws Exception{
        //通过studentMapperCustom查询数据库
        return studentMapperCustom.findStudentExist(studentCustom);
    }

    @Override
    public StudentCustom findStudentById(Integer id) throws Exception {
        Student student=studentMapper.selectByPrimaryKey(id);
        StudentCustom studentCustom=new StudentCustom();
        if(student==null){
            return null;
        }
        BeanUtils.copyProperties(student,studentCustom);//将student中的属性copy到studentCustom
        return studentCustom;
    }

    @Override
    public void updataStudent(StudentCustom studentCustom) throws Exception {
        studentMapper.updateByPrimaryKey(studentCustom);
    }

    @Override
    public void backoutidentity(Integer comid) {
        studentMapperCustom.backoutidentity(comid);
    }

    @Override
    public void uptoidentity(Integer stuid) {
        Student student=studentMapper.selectByPrimaryKey(stuid);
        student.setIdentity(1);
        studentMapper.updateByPrimaryKeySelective(student);
    }
}
