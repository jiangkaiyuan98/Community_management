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
            modelAndView.addObject("message","�����ڸ�id����Ա");
            //�ƶ���ͼ
            modelAndView.setViewName("community/addCommunity");
            return modelAndView;
        }
        else if(studentCustom.getIdentity()==2){//�ж��Ƿ��Ѿ����糤
            CommunityMembers communityMembers=new CommunityMembers();
            communityMembers.setStuid(communityCustom.getPresidentid());
            communityService.addCommunitySubmit(communityCustom,communityMembers);//������ţ����糤���뵽����
            studentService.uptoidentity(communityCustom.getPresidentid());//�����������
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("communityCustom", communityCustom);
            modelAndView.addObject("message","������ųɹ�!!");
            //�ƶ���ͼ
            modelAndView.setViewName("community/addCommunity");
            return modelAndView;
        }
        else{
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("communityCustom", communityCustom);
            modelAndView.addObject("message","�ó�Ա�Ѿ����糤����������Ϊ�����糤");
            //�ƶ���ͼ
            modelAndView.setViewName("community/addCommunity");
            return modelAndView;
        }
    }

    @RequestMapping("/addCommunity")
    public String addCommunity()throws Exception{
        return "community/addCommunity";
    }

    @RequestMapping("/findCommunityMembersList")//�糤�鿴���ŵĳ�Ա id:����id
    public ModelAndView findCommunityMembersList(Integer id,CommunityCustom communityCustom)throws Exception{
        List<StudentCustom> studentCustomList=communityService.findCommunityMembersList(id);
        List<Integer> join_act_num=new ArrayList<>();
        for(StudentCustom studentCustom:studentCustomList)//ͳ��
        join_act_num.add(activateService.join_act_num(studentCustom.getId(),communityCustom.getId()));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("communityCustom", communityCustom);
        modelAndView.addObject("studentCustomList", studentCustomList);
        modelAndView.addObject("join_act_num", join_act_num);
        //�ƶ���ͼ
        modelAndView.setViewName("community/communityMembersList");
        return modelAndView;
    }
    @RequestMapping("findCanJoinCommunityList")//�鿴������������
    public ModelAndView findCanJoinCommunityList(StudentCustom studentCustom)throws Exception{
        List<CommunityCustom> communityCustomList=communityService.findCommunityList(studentCustom);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("communityCustomList", communityCustomList);
        modelAndView.addObject("studentCustom",studentCustom);
        modelAndView.setViewName("community/can_join_communityList");
        return modelAndView;
    }
    @RequestMapping(value="join_community",produces = "text/html;charset=UTF-8" )//������������
    public @ResponseBody String join_community(@RequestBody JoinCommunity joinCommunity)throws Exception{
        joinCommunity.setState(0);
        if(communityService.communityMembers_exist(joinCommunity)==null) {
            communityService.join_community(joinCommunity);
            String result="�����ɹ�";
            return result;
        }
        else{
            String result="�벻Ҫ�ظ�����";
            return result;
        }
    }
    @RequestMapping("check_join_community")//��ת���������ų�Աҳ��
    public ModelAndView check_join_community(Integer comid)throws Exception{
        List<JoinCommunityCustom> joinCommunityCustomList=communityService.findJoinCommunityList(comid);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("joinCommunityCustomList",joinCommunityCustomList);
        modelAndView.setViewName("/community/check_join_community");
        return modelAndView;
    }
    @RequestMapping("choose_communityMembers")//����flag�ж�state��ֵ
    public ModelAndView choose_communityMembers(Integer flag,Integer comid,Integer stuid)throws Exception{
        JoinCommunity joinCommunity=new JoinCommunity();
        joinCommunity.setState(flag);
        joinCommunity.setComid(comid);
        joinCommunity.setStuid(stuid);
        CommunityMembers communityMembers=new CommunityMembers();
        communityMembers.setStuid(stuid);
        communityMembers.setComid(comid);
        if(flag==1){
            communityService.updateJoin_Community(joinCommunity);//����joinCommunity��
            communityService.insertCommunityMembers(communityMembers);//���뵽��ʽ�ĳ�Ա��CommunMembers
        }else if(flag==2){
            communityService.updateJoin_Community(joinCommunity);//����joinCommunity��
        }
        return check_join_community(comid);
    }
    @RequestMapping("deleteCommunityMembers")//����stuid��comidɾ����Ա
    public ModelAndView deleteCommunityMembers(Integer stuid,Integer comid)throws Exception{
        CommunityMembers communityMembers=new CommunityMembers();
        communityMembers.setComid(comid);
        communityMembers.setStuid(stuid);
        communityService.deleteCommunityMembers(communityMembers);
        CommunityCustom communityCustom=new CommunityCustom();
        communityCustom.setId(comid);
        return findCommunityMembersList(comid,communityCustom);//ɾ�������
    }
    @RequestMapping("jump_changeProprieter")//��ת�������糤ҳ��
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
        //�ƶ���ͼ
        modelAndView.setViewName("community/root_communityMembersList_forProprieter");
        return modelAndView;
    }
    @RequestMapping("changeProprieter")//�����糤
    public ModelAndView changeProprieter(Integer stuid,Integer comid)throws Exception{
        StudentCustom studentCustom=studentService.findStudentById(stuid);
        if(studentCustom.getIdentity()==2){//���֮ǰ����ͨ��Ա
            studentService.backoutidentity(comid);//����ԭ�糤�������id��Ϊ2
            communityService.updateNewProprieter(comid,stuid);//�����ű���糤id��Ϊstuid
            studentService.uptoidentity(stuid);//�����糤��ݸ�Ϊ1,�Ȳ���stuid��id��ѧ������ݸ�Ϊ1��Ȼ��update
            return jump_changeProprieter(comid);
        }
        else{
            ModelAndView modelAndView=jump_changeProprieter(comid);
            modelAndView.addObject("error","�ó�Ա�Ѿ����������糤�����β���ȡ��");
            return modelAndView;
        }
    }
}
