package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.ActivityMembers;
import cn.itcast.ssm.po.ActivityMembersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityMembersMapper {
    int countByExample(ActivityMembersExample example);

    int deleteByExample(ActivityMembersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityMembers record);

    int insertSelective(ActivityMembers record);

    List<ActivityMembers> selectByExample(ActivityMembersExample example);

    ActivityMembers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivityMembers record, @Param("example") ActivityMembersExample example);

    int updateByExample(@Param("record") ActivityMembers record, @Param("example") ActivityMembersExample example);

    int updateByPrimaryKeySelective(ActivityMembers record);

    int updateByPrimaryKey(ActivityMembers record);
}