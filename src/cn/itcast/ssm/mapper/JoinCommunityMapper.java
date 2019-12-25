package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.JoinCommunity;
import cn.itcast.ssm.po.JoinCommunityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JoinCommunityMapper {
    int countByExample(JoinCommunityExample example);

    int deleteByExample(JoinCommunityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JoinCommunity record);

    int insertSelective(JoinCommunity record);

    List<JoinCommunity> selectByExample(JoinCommunityExample example);

    JoinCommunity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JoinCommunity record, @Param("example") JoinCommunityExample example);

    int updateByExample(@Param("record") JoinCommunity record, @Param("example") JoinCommunityExample example);

    int updateByPrimaryKeySelective(JoinCommunity record);

    int updateByPrimaryKey(JoinCommunity record);
}