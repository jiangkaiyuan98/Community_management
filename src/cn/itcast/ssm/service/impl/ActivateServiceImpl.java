package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.mapper.*;
import cn.itcast.ssm.po.*;
import cn.itcast.ssm.service.ActivateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ActivateServiceImpl implements ActivateService {
    @Autowired
    private ActivateMapperCustom activateMapperCustom;
    @Autowired
    private ActivateMapper activateMapper;
    @Autowired
    private ActivityMembersMapper activityMembersMapper;
    @Autowired
    private ActivityMembersMapperCustom activityMembersMapperCustom;
    @Autowired
    private JoinActivityMembersMapperCustom joinActivityMembersMapperCustom;
    @Autowired
    private JoinActivityMembersMapper joinActivityMembersMapper;
    @Override
    public List<ActivateCustom> findActivateList(Integer id) throws Exception {
        return activateMapperCustom.findActivateList(id);
    }

    @Override
    public void insertActivate(Activate activate) throws Exception {
        activateMapper.insert(activate);
    }

    @Override
    public void deleteByPrimaryKey(Integer id) throws Exception {
        activateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateByPrimaryKey(ActivateQueryVo activateQueryVo) throws Exception {
        List<ActivateCustom> activateList=activateQueryVo.getActivateCustomList();
        for(ActivateCustom activate:activateList){
            activateMapper.updateByPrimaryKey(activate);
        }
    }

    @Override
    public Integer join_act_num(Integer stu_id, Integer com_id) throws Exception {
        return activityMembersMapperCustom.join_act_num(stu_id,com_id);
    }

    @Override
    public void join_activate_cache(JoinActivityMembers joinActivityMembers) throws Exception {
        joinActivityMembersMapper.insert(joinActivityMembers);
    }

    @Override
    public JoinActivityMembers join_activateMembers_exist(JoinActivityMembers joinActivityMembers) throws Exception {
        return joinActivityMembersMapperCustom.join_activateMembers_exist(joinActivityMembers);
    }

    @Override
    public List<JoinActivityMembersCustom> find_all_join_activityMembersList(Integer act_id) throws Exception {
        return joinActivityMembersMapperCustom.find_all_join_activityMembersList(act_id);
    }

    @Override
    public void updateJoin_act_Members(JoinActivityMembers joinActivityMembers) throws Exception {
        joinActivityMembersMapperCustom.updataBystuid_actid(joinActivityMembers);
    }

    @Override
    public void insertAvtivityMembers(ActivityMembers activityMembers) throws Exception {
        activityMembersMapper.insert(activityMembers);
    }

    @Override
    public List<ActivityMembersCustom> findActivityMembers(Integer activateid) {
        return activityMembersMapperCustom.findActivityMembers(activateid);
    }

    @Override
    public void deleteByPrimaryKey_ActivityMembers(Integer id) throws Exception {
        activityMembersMapper.deleteByPrimaryKey(id);//逆向工程生成的
    }


}
