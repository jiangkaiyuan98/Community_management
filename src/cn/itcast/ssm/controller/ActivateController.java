package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.*;
import cn.itcast.ssm.service.ActivateService;
import cn.itcast.ssm.service.CommunityService;
import cn.itcast.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/activates")
public class ActivateController {
    @Autowired
    private ActivateService activateService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CommunityService communityService;
    /**
    * @Description TODO ���������б�
    * @param id ���ű��
    * @param identity ������Ա���
    * @param stuid ������Աid
    * @param flag ������Ա�Ƿ�Ϊ���ű��Ϊid���糤�����û��flag���Լ��ж�
    * @Return 
    * @Author root
    * @Date  
    **/
    @RequestMapping("/findActivateList")
    public ModelAndView findActivateList(Integer id,Integer identity,Integer stuid,Integer flag)throws Exception{
        List<ActivateCustom> activateCustomList=activateService.findActivateList(id);//���������б�
        StudentCustom studentCustom=studentService.findStudentById(stuid);//���ҵ�ǰ��½���û�����Ϣ
        Community community=communityService.findCommunityById(id);//����������Ϣ
        if(community.getPresidentid()==stuid){//������Ա�Ƿ�Ϊ���ű��Ϊid���糤
            flag=1;
        }
        Integer comid=id;
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("activateCustomList", activateCustomList);
        modelAndView.addObject("comid",comid);
        modelAndView.addObject("identity",identity);//!!!!!!!!!
        modelAndView.addObject("stuid",stuid);//!!!!!!!!!
        modelAndView.addObject("flag",flag);
        modelAndView.addObject("studentCustom",studentCustom);
        //�ƶ���ͼ
        modelAndView.setViewName("activate/activateList");
        return modelAndView;
    }

    @RequestMapping("sentActivateList")
    public String sentActivateList(Integer comid, Activate activate,Integer flag)throws Exception{
        activate.setComid(comid);//���������
        activate.setState(0);
        System.out.println("������Ϊ��"+activate.getName());
        System.out.println("�������"+activate.getDescription());
        activateService.insertActivate(activate);
        return "forward:findActivateList.action?identity=1&&id="+comid+"&&flag="+flag;//���²��Ҹ�����comid�Ļ�б�
    }
    /**
    * @Description TODO
    * @param id �id
    * @param comid ����id ����ҳ��ʱ�õ�
    * @Return ���²��Ҹ�����comid�Ļ�б�
    * @Author root
    * @Date  
    **/
    @RequestMapping("deleteActivate")//����Աɾ���
    public String deleteActivate(Integer id,Integer comid)throws Exception{
        activateService.deleteByPrimaryKey(id);
        return "forward:findActivateList.action?identity=0&&id="+comid;//���²��Ҹ�����comid�Ļ�б�
    }
    @RequestMapping("the_submitActivateList")
    public String the_submitActivateList(ActivateQueryVo activateQueryVo,@RequestParam("comid") Integer id)throws Exception{
        activateService.updateByPrimaryKey(activateQueryVo);
        return "forward:findActivateList.action?identity=0&&id="+id;//���²��Ҹ�����comid�Ļ�б�
    }
    @RequestMapping(value = "join_activate_cache",produces = "text/html;charset=UTF-8")//�����
    public @ResponseBody String join_activate_cache(@RequestBody JoinActivityMembers joinActivityMembers)throws Exception{
        joinActivityMembers.setState(0);
        if(activateService.join_activateMembers_exist(joinActivityMembers)==null){
            activateService.join_activate_cache(joinActivityMembers);
            return "�����ɹ�";
        }
        else{
            return "�����ظ�����";
        }
    }
    @RequestMapping("check_join_activityMembers")
    public ModelAndView check_join_activityMembers(Integer act_id)throws Exception{
        List<JoinActivityMembersCustom> joinActivityMembersCustomList=activateService.find_all_join_activityMembersList(act_id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("joinActivityMembersCustomList",joinActivityMembersCustomList);
        modelAndView.setViewName("activate/check_join_activityMembers");
        return modelAndView;
    }
    @RequestMapping("choose_activityMembers")//������������ĳ�Ա
    public ModelAndView choose_activityMembers(Integer flag,Integer activateid,Integer stuId)throws Exception{
        JoinActivityMembers joinActivityMembers=new JoinActivityMembers();
        joinActivityMembers.setState(flag);
        joinActivityMembers.setStuid(stuId);
        joinActivityMembers.setActivateid(activateid);
        ActivityMembers activityMembers=new ActivityMembers();
        activityMembers.setActivateid(activateid);
        activityMembers.setStuid(stuId);
        if(flag==1){//ͨ�����
            activateService.updateJoin_act_Members(joinActivityMembers);//updata join��
            activateService.insertAvtivityMembers(activityMembers);//����Ϣinsert����ʽ��
        }else if(flag==2){//δͨ�����
            activateService.updateJoin_act_Members(joinActivityMembers);//updata join��
        }
        return check_join_activityMembers(activateid);
    }
    @RequestMapping("findActivityMembers")
    public ModelAndView findActivityMembers(Integer activateid)throws Exception{
        List<ActivityMembersCustom> activityMembersCustomList=activateService.findActivityMembers(activateid);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("activityMembersCustomList",activityMembersCustomList);
        modelAndView.setViewName("activate/activityMembers");
        return modelAndView;
    }
    /**
    * @Description TODO
    * @param id ���Ա���id
    * @param activateid �id Ϊ�˻���
    * @Return 
    * @Author root
    * @Date  
    **/
    @RequestMapping("deleteActivityMembers")
    public ModelAndView deleteActivityMembers(Integer id,Integer activateid)throws Exception{
        activateService.deleteByPrimaryKey_ActivityMembers(id);
        return findActivityMembers(activateid);
    }
}
