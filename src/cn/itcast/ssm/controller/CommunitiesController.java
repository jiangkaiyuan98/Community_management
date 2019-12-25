package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.*;
import cn.itcast.ssm.service.ActivateService;
import cn.itcast.ssm.service.CommunityService;
import cn.itcast.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/communities")
public class CommunitiesController {
    @Autowired
    private CommunityService communityService;
    @Autowired
    private ActivateService activateService;
    @Autowired
    private StudentService studentService;
    @RequestMapping("/addCommunitySubmit")
    public ModelAndView addCommunitySubmit(CommunityCustom communityCustom)throws Exception{
        StudentCustom studentCustom=studentService.findStudentById(communityCustom.getPresidentid());
        if(studentCustom==null){
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("communityCustom", communityCustom);
            modelAndView.addObject("message","不存在该id的人员");
            //制定试图
            modelAndView.setViewName("community/addCommunity");
            return modelAndView;
        }
        else if(studentCustom.getIdentity()==2){//判断是否已经是社长
            CommunityMembers communityMembers=new CommunityMembers();
            communityMembers.setStuid(communityCustom.getPresidentid());
            communityService.addCommunitySubmit(communityCustom,communityMembers);//添加社团，将社长加入到社团
            studentService.uptoidentity(communityCustom.getPresidentid());//将其身份升级
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("communityCustom", communityCustom);
            modelAndView.addObject("message","添加社团成功!!");
            //制定试图
            modelAndView.setViewName("community/addCommunity");
            return modelAndView;
        }
        else{
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("communityCustom", communityCustom);
            modelAndView.addObject("message","该成员已经是社长，不能再作为其他社长");
            //制定试图
            modelAndView.setViewName("community/addCommunity");
            return modelAndView;
        }
    }

    @RequestMapping("/addCommunity")
    public String addCommunity()throws Exception{
        return "community/addCommunity";
    }

    @RequestMapping("/findCommunityMembersList")//社长查看社团的成员 id:社团id
    public ModelAndView findCommunityMembersList(Integer id,CommunityCustom communityCustom)throws Exception{
        List<StudentCustom> studentCustomList=communityService.findCommunityMembersList(id);
        List<Integer> join_act_num=new ArrayList<>();
        for(StudentCustom studentCustom:studentCustomList)//统计
        join_act_num.add(activateService.join_act_num(studentCustom.getId(),communityCustom.getId()));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("communityCustom", communityCustom);
        modelAndView.addObject("studentCustomList", studentCustomList);
        modelAndView.addObject("join_act_num", join_act_num);
        //制定试图
        modelAndView.setViewName("community/communityMembersList");
        return modelAndView;
    }
    @RequestMapping("findCanJoinCommunityList")//查看允许加入的社团
    public ModelAndView findCanJoinCommunityList(StudentCustom studentCustom)throws Exception{
        List<CommunityCustom> communityCustomList=communityService.findCommunityList(studentCustom);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("communityCustomList", communityCustomList);
        modelAndView.addObject("studentCustom",studentCustom);
        modelAndView.setViewName("community/can_join_communityList");
        return modelAndView;
    }
    @RequestMapping(value="join_community",produces = "text/html;charset=UTF-8" )//报名加入社团
    public @ResponseBody String join_community(@RequestBody JoinCommunity joinCommunity)throws Exception{
        joinCommunity.setState(0);
        if(communityService.communityMembers_exist(joinCommunity)==null) {
            communityService.join_community(joinCommunity);
            String result="报名成功";
            return result;
        }
        else{
            String result="请不要重复报名";
            return result;
        }
    }
    @RequestMapping("check_join_community")//跳转到审批社团成员页面
    public ModelAndView check_join_community(Integer comid)throws Exception{
        List<JoinCommunityCustom> joinCommunityCustomList=communityService.findJoinCommunityList(comid);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("joinCommunityCustomList",joinCommunityCustomList);
        modelAndView.setViewName("/community/check_join_community");
        return modelAndView;
    }
    @RequestMapping("choose_communityMembers")//根据flag判断state赋值
    public ModelAndView choose_communityMembers(Integer flag,Integer comid,Integer stuid)throws Exception{
        JoinCommunity joinCommunity=new JoinCommunity();
        joinCommunity.setState(flag);
        joinCommunity.setComid(comid);
        joinCommunity.setStuid(stuid);
        CommunityMembers communityMembers=new CommunityMembers();
        communityMembers.setStuid(stuid);
        communityMembers.setComid(comid);
        if(flag==1){
            communityService.updateJoin_Community(joinCommunity);//更新joinCommunity表
            communityService.insertCommunityMembers(communityMembers);//加入到正式的成员表CommunMembers
        }else if(flag==2){
            communityService.updateJoin_Community(joinCommunity);//更新joinCommunity表
        }
        return check_join_community(comid);
    }
    @RequestMapping("deleteCommunityMembers")//根据stuid和comid删除成员
    public ModelAndView deleteCommunityMembers(Integer stuid,Integer comid)throws Exception{
        CommunityMembers communityMembers=new CommunityMembers();
        communityMembers.setComid(comid);
        communityMembers.setStuid(stuid);
        communityService.deleteCommunityMembers(communityMembers);
        CommunityCustom communityCustom=new CommunityCustom();
        communityCustom.setId(comid);
        return findCommunityMembersList(comid,communityCustom);//删除后回显
    }
    @RequestMapping("jump_changeProprieter")//跳转到更换社长页面
    public ModelAndView jump_changeProprieter(Integer comid)throws Exception{
        List<StudentCustom> studentCustomList=communityService.findCommunityMembersList(comid);
        List<Integer> join_act_num=new ArrayList<>();
        for(StudentCustom studentCustom:studentCustomList)
            join_act_num.add(activateService.join_act_num(studentCustom.getId(),comid));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("comid",comid);
        modelAndView.addObject("studentCustomList", studentCustomList);
        modelAndView.addObject("join_act_num", join_act_num);
        modelAndView.addObject("error","");
        //制定试图
        modelAndView.setViewName("community/root_communityMembersList_forProprieter");
        return modelAndView;
    }
    @RequestMapping("changeProprieter")//更换社长
    public ModelAndView changeProprieter(Integer stuid,Integer comid)throws Exception{
        StudentCustom studentCustom=studentService.findStudentById(stuid);
        if(studentCustom.getIdentity()==2){//如果之前是普通成员
            studentService.backoutidentity(comid);//查找原社长将其身份id改为2
            communityService.updateNewProprieter(comid,stuid);//将社团表的社长id改为stuid
            studentService.uptoidentity(stuid);//将新社长身份改为1,先查找stuid的id的学生，身份改为1，然后update
            return jump_changeProprieter(comid);
        }
        else{
            ModelAndView modelAndView=jump_changeProprieter(comid);
            modelAndView.addObject("error","该成员已经是其他社社长，本次操作取消");
            return modelAndView;
        }
    }
}
