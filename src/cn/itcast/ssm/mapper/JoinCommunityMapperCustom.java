package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.JoinCommunity;
import cn.itcast.ssm.po.JoinCommunityCustom;

import java.util.List;

public interface JoinCommunityMapperCustom {
    public JoinCommunity community_members_exist(JoinCommunity joinCommunity)throws Exception;//根据stuId和comId判断是否已经存在

    List<JoinCommunityCustom> findJoinCommunityList(Integer comid);//根据社团id查找申请加入该社团的成员

    void updateBycomid_stuid(JoinCommunity joinCommunity);
}
