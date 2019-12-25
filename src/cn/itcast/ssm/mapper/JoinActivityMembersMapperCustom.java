package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.JoinActivityMembers;
import cn.itcast.ssm.po.JoinActivityMembersCustom;
import cn.itcast.ssm.po.JoinActivityMembersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JoinActivityMembersMapperCustom {
     JoinActivityMembers join_activateMembers_exist(JoinActivityMembers joinActivityMembers)throws Exception;
     List<JoinActivityMembersCustom> find_all_join_activityMembersList(Integer act_id)throws Exception;
     void updataBystuid_actid(JoinActivityMembers joinActivityMembers)throws Exception;
}