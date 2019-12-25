package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.ActivityMembersCustom;

import java.util.List;

public interface ActivityMembersMapperCustom {
    public Integer join_act_num(Integer stu_id, Integer com_id) throws Exception;

    List<ActivityMembersCustom> findActivityMembers(Integer activateid);
}