package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.Community;
import cn.itcast.ssm.po.CommunityCustom;
import cn.itcast.ssm.po.CommunityMembers;
import cn.itcast.ssm.po.StudentCustom;

import java.util.List;

public interface CommunityMapperCustom {
    public List<CommunityCustom> findCommunityList()throws Exception;//社长查询所有社团
    public List<CommunityCustom> findMy_CommunityList(StudentCustom studentCustom)throws Exception;
    public List<StudentCustom> findCommunityMembersList(Integer id)throws Exception;
    public List<CommunityCustom> findCommunityList(StudentCustom studentCustom)throws Exception;

    void deleteCommunityMembers(CommunityMembers communityMembers);

    Community select_new_community(Community community);
}
