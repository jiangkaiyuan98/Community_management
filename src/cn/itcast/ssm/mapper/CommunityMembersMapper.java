package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.CommunityMembers;
import cn.itcast.ssm.po.CommunityMembersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommunityMembersMapper {
    int countByExample(CommunityMembersExample example);

    int deleteByExample(CommunityMembersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommunityMembers record);

    int insertSelective(CommunityMembers record);

    List<CommunityMembers> selectByExample(CommunityMembersExample example);

    CommunityMembers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommunityMembers record, @Param("example") CommunityMembersExample example);

    int updateByExample(@Param("record") CommunityMembers record, @Param("example") CommunityMembersExample example);

    int updateByPrimaryKeySelective(CommunityMembers record);

    int updateByPrimaryKey(CommunityMembers record);
}