package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.mapper.*;
import cn.itcast.ssm.po.*;
import cn.itcast.ssm.service.CommunityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommunityServiceImpl implements CommunityService {
    @Autowired
    private CommunityMapper communityMapper;
    @Autowired
    private CommunityMapperCustom communityMapperCustom;
    @Autowired
    private CommunityMembersMapper communityMembersMapper;
    @Autowired
    private JoinCommunityMapper joinCommunityMapper;
    @Autowired
    private JoinCommunityMapperCustom joinCommunityMapperCustom;

    public void insertCommunity(CommunityCustom communityCustom) throws Exception {
        Community community=new Community();
        BeanUtils.copyProperties(communityCustom,community);
        communityMapper.insert(community);
    }

    @Override
    public List<CommunityCustom> findCommunityList() throws Exception {
        return communityMapperCustom.findCommunityList();//社长查询所有社团
    }

    @Override
    public List<CommunityCustom> findMy_CommunityList(StudentCustom studentCustom) throws Exception {
        return communityMapperCustom.findMy_CommunityList(studentCustom);
    }

    //查找社团成员列表 id为社团id
    @Override
    public List<StudentCustom> findCommunityMembersList(Integer id) throws Exception {
        return communityMapperCustom.findCommunityMembersList(id);
    }

    @Override
    public List<CommunityCustom> findCommunityList(StudentCustom studentCustom) throws Exception {
        return communityMapperCustom.findCommunityList(studentCustom);
    }

    @Override
    public void join_community(JoinCommunity joinCommunity) throws Exception {
        joinCommunityMapper.insert(joinCommunity);
    }

    @Override
    public JoinCommunity communityMembers_exist(JoinCommunity joinCommunity) throws Exception {
        return joinCommunityMapperCustom.community_members_exist(joinCommunity);
    }

    @Override
    public List<JoinCommunityCustom> findJoinCommunityList(Integer comid) {
        return joinCommunityMapperCustom.findJoinCommunityList(comid);
    }

    @Override
    public void updateJoin_Community(JoinCommunity joinCommunity) {
        joinCommunityMapperCustom.updateBycomid_stuid(joinCommunity);
    }

    @Override
    public void insertCommunityMembers(CommunityMembers communityMembers) {
        communityMembersMapper.insert(communityMembers);
    }

    @Override
    public void deleteCommunityMembers(CommunityMembers communityMembers) {
        communityMapperCustom.deleteCommunityMembers(communityMembers);
    }

    @Override
    public void updateNewProprieter(Integer comid, Integer stuid) {
        Community community=communityMapper.selectByPrimaryKey(comid);
        community.setPresidentid(stuid);
        communityMapper.updateByPrimaryKeySelective(community);//有bug所以写的麻烦
    }

    @Override
    public void addCommunitySubmit(CommunityCustom communityCustom, CommunityMembers communityMembers) {
        Community community=new Community();
        BeanUtils.copyProperties(communityCustom,community);
        communityMapper.insert(community);
        Community community1=communityMapperCustom.select_new_community(community);
        communityMembers.setComid(community1.getId());
        communityMembersMapper.insert(communityMembers);
    }

    @Override
    public Community findCommunityById(Integer id) {
        return communityMapper.selectByPrimaryKey(id);
    }

}
