package cn.itcast.ssm.service;

import cn.itcast.ssm.po.*;

import java.util.List;

public interface ActivateService {
    public List<ActivateCustom> findActivateList(Integer id)throws Exception;
    public void insertActivate(Activate activate)throws Exception;
    public void deleteByPrimaryKey(Integer id)throws Exception;
    public void updateByPrimaryKey(ActivateQueryVo activateQueryVo)throws Exception;
    public Integer join_act_num(Integer stu_id,Integer com_id)throws Exception;//学生加入社团活动的数目
    public void join_activate_cache(JoinActivityMembers joinActivityMembers)throws Exception;//报名加入社团
    public JoinActivityMembers join_activateMembers_exist(JoinActivityMembers joinActivityMembers)throws Exception;//报名前判断是否已经报过名
    public List<JoinActivityMembersCustom> find_all_join_activityMembersList(Integer act_id)throws Exception;//查找所有报名参加id为act_id的人
    public void updateJoin_act_Members(JoinActivityMembers joinActivityMembers)throws Exception;//update joinactMembers的表，更改state
    public void insertAvtivityMembers(ActivityMembers activityMembers)throws Exception;//通过审核加入到正式表
    List<ActivityMembersCustom> findActivityMembers(Integer activateid);//查找活动成员
    void deleteByPrimaryKey_ActivityMembers(Integer id)throws Exception;//根据主键删除活动成员
}
