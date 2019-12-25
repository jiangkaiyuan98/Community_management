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
    * @Description TODO 查找社团列表
    * @param id 社团编号
    * @param identity 操作人员身份
    * @param stuid 操作人员id
    * @param flag 操作人员是否为社团编号为id的社长，如果没有flag会自己判断
    * @Return 
    * @Author root
    * @Date  
    **/
    @RequestMapping("/findActivateList")
    public ModelAndView findActivateList(Integer id,Integer identity,Integer stuid,Integer flag)throws Exception{
        List<ActivateCustom> activateCustomList=activateService.findActivateList(id);//查找社团列表
        StudentCustom studentCustom=studentService.findStudentById(stuid);//查找当前登陆的用户的信息
        Community community=communityService.findCommunityById(id);//查找社团信息
        if(community.getPresidentid()==stuid){//操作人员是否为社团编号为id的社长
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
        //制定试图
        modelAndView.setViewName("activate/activateList");
        return modelAndView;
    }

    @RequestMapping("sentActivateList")
    public String sentActivateList(Integer comid, Activate activate,Integer flag)throws Exception{
        activate.setComid(comid);//好像多余了
        activate.setState(0);
        System.out.println("社团名为："+activate.getName());
        System.out.println("活动描述："+activate.getDescription());
        activateService.insertActivate(activate);
        return "forward:findActivateList.action?identity=1&&id="+comid+"&&flag="+flag;//重新查找该社团comid的活动列表
    }
    /**
    * @Description TODO
    * @param id 活动id
    * @param comid 社团id 返回页面时用到
    * @Return 重新查找该社团comid的活动列表
    * @Author root
    * @Date  
    **/
    @RequestMapping("deleteActivate")//管理员删除活动
    public String deleteActivate(Integer id,Integer comid)throws Exception{
        activateService.deleteByPrimaryKey(id);
        return "forward:findActivateList.action?identity=0&&id="+comid;//重新查找该社团comid的活动列表
    }
    @RequestMapping("the_submitActivateList")
    public String the_submitActivateList(ActivateQueryVo activateQueryVo,@RequestParam("comid") Integer id)throws Exception{
        activateService.updateByPrimaryKey(activateQueryVo);
        return "forward:findActivateList.action?identity=0&&id="+id;//重新查找该社团comid的活动列表
    }
    @RequestMapping(value = "join_activate_cache",produces = "text/html;charset=UTF-8")//活动报名
    public @ResponseBody String join_activate_cache(@RequestBody JoinActivityMembers joinActivityMembers)throws Exception{
        joinActivityMembers.setState(0);
        if(activateService.join_activateMembers_exist(joinActivityMembers)==null){
            activateService.join_activate_cache(joinActivityMembers);
            return "报名成功";
        }
        else{
            return "请勿重复报名";
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
    @RequestMapping("choose_activityMembers")//审批申请加入活动的成员
    public ModelAndView choose_activityMembers(Integer flag,Integer activateid,Integer stuId)throws Exception{
        JoinActivityMembers joinActivityMembers=new JoinActivityMembers();
        joinActivityMembers.setState(flag);
        joinActivityMembers.setStuid(stuId);
        joinActivityMembers.setActivateid(activateid);
        ActivityMembers activityMembers=new ActivityMembers();
        activityMembers.setActivateid(activateid);
        activityMembers.setStuid(stuId);
        if(flag==1){//通过审核
            activateService.updateJoin_act_Members(joinActivityMembers);//updata join表
            activateService.insertAvtivityMembers(activityMembers);//将信息insert到正式表
        }else if(flag==2){//未通过审核
            activateService.updateJoin_act_Members(joinActivityMembers);//updata join表
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
    * @param id 活动成员表的id
    * @param activateid 活动id 为了回显
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
