package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.JoinCommunity;
import cn.itcast.ssm.po.JoinCommunityCustom;

import java.util.List;

public interface JoinCommunityMapperCustom {
    public JoinCommunity community_members_exist(JoinCommunity joinCommunity)throws Exception;//����stuId��comId�ж��Ƿ��Ѿ�����

    List<JoinCommunityCustom> findJoinCommunityList(Integer comid);//��������id���������������ŵĳ�Ա

    void updateBycomid_stuid(JoinCommunity joinCommunity);
}
