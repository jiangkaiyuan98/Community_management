package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.Community;
import cn.itcast.ssm.po.CommunityCustom;
import cn.itcast.ssm.po.StudentCustom;
import cn.itcast.ssm.service.CommunityService;
import cn.itcast.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CommunityService communityService;

    @RequestMapping("/student_login")
    public ModelAndView student_login(HttpServletRequest request, HttpServletResponse response)throws Exception{
        StudentCustom studentCustom=new StudentCustom();
        studentCustom.setUsername(request.getParameter("username"));
        studentCustom.setPassword(request.getParameter("password"));
        studentCustom=studentService.findStudentExist(studentCustom);//判断用户是否存在,返回用户信息对象
        //返回ModelAndview
        ModelAndView modelAndView=new ModelAndView();
        if(studentCustom==null){
            String error="用户名或密码不正确";
            modelAndView.addObject("error",error);
            //制定试图
            modelAndView.setViewName("index");
            return modelAndView;
        }else if(studentCustom.getIdentity()==2||studentCustom.getIdentity()==1){
            //相当于request.setAttribut，在jsp页面中通过itemsList
            List<CommunityCustom> communityCustomList=communityService.findMy_CommunityList(studentCustom);//我参加的社团列表
            modelAndView.addObject("studentCustom", studentCustom);
            modelAndView.addObject("communityCustomList",communityCustomList);
            //制定试图
            modelAndView.setViewName("student/success");
            return modelAndView;
        }
        else if(studentCustom.getIdentity()==0){
            List<CommunityCustom> communityCustomList=communityService.findCommunityList();
            modelAndView.addObject("communityCustomList", communityCustomList);
            //制定试图
            modelAndView.setViewName("student/root_success");//管理员身份的管理页面
            return modelAndView;
        }
        else{
            modelAndView.setViewName("index");
            return modelAndView;
        }
    }
    @RequestMapping("/edit_student")
    public ModelAndView student_edit(Integer id)throws Exception{
        StudentCustom studentCustom=studentService.findStudentById(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("studentCustom", studentCustom);
        //制定试图
        modelAndView.setViewName("student/editStudent");
        return modelAndView;
    }

    @RequestMapping("/found_my_community")
    public ModelAndView found_my_community(Integer id)throws Exception{
        Community community=new Community();
        ModelAndView modelAndView=new ModelAndView();
        //modelAndView.addObject("studentCustom", studentCustom);
        //制定试图
        modelAndView.setViewName("student/editStudent");
        return modelAndView;
    }
    @RequestMapping("/editStudentSubmit")
    public ModelAndView editStudentSubmit(StudentCustom studentCustom)throws Exception{
        studentService.updataStudent(studentCustom);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("studentCustom", studentCustom);
        //制定试图
        modelAndView.setViewName("student/editStudent");
        return modelAndView;
    }
}
