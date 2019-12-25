package cn.itcast.ssm.service;

import cn.itcast.ssm.po.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CommunityService {
    public void insertCommunity(CommunityCustom communityCustom)throws Exception;//添加社团
    public List<CommunityCustom> findCommunityList()throws Exception;//管理员查找所有社团
    public List<CommunityCustom> findMy_CommunityList(StudentCustom studentCustom)throws Exception;//查找加入的社团
    public List<StudentCustom> findCommunityMembersList(Integer id)throws Exception;//社长查看社团成员
    public List<CommunityCustom> findCommunityList(StudentCustom studentCustom)throws Exception;//管理员查找所有社团
    public void join_community(JoinCommunity joinCommunity)throws Exception;//报名加入社团
    public JoinCommunity communityMembers_exist(JoinCommunity joinCommunity)throws Exception;//报名前判断是否已经报过名
    List<JoinCommunityCustom> findJoinCommunityList(Integer comid);//查找申请参加社团的人

    void updateJoin_Community(JoinCommunity joinCommunity);//更新JoinCommunity表中的state

    void insertCommunityMembers(CommunityMembers communityMembers);//将通过的成员添加到正式表CommunityMembers中

    void deleteCommunityMembers(CommunityMembers communityMembers);//通过stuid和comid删除社团成员

    void updateNewProprieter(Integer comid, Integer stuid);

    void addCommunitySubmit(CommunityCustom communityCustom, CommunityMembers communityMembers);

    Community findCommunityById(Integer id);
}
