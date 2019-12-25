package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.JoinActivityMembers;
import cn.itcast.ssm.po.JoinActivityMembersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JoinActivityMembersMapper {
    int countByExample(JoinActivityMembersExample example);

    int deleteByExample(JoinActivityMembersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JoinActivityMembers record);

    int insertSelective(JoinActivityMembers record);

    List<JoinActivityMembers> selectByExample(JoinActivityMembersExample example);

    JoinActivityMembers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JoinActivityMembers record, @Param("example") JoinActivityMembersExample example);

    int updateByExample(@Param("record") JoinActivityMembers record, @Param("example") JoinActivityMembersExample example);

    int updateByPrimaryKeySelective(JoinActivityMembers record);

    int updateByPrimaryKey(JoinActivityMembers record);
}