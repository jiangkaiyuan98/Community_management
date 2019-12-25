package cn.itcast.ssm.service;

import cn.itcast.ssm.po.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CommunityService {
    public void insertCommunity(CommunityCustom communityCustom)throws Exception;//�������
    public List<CommunityCustom> findCommunityList()throws Exception;//����Ա������������
    public List<CommunityCustom> findMy_CommunityList(StudentCustom studentCustom)throws Exception;//���Ҽ��������
    public List<StudentCustom> findCommunityMembersList(Integer id)throws Exception;//�糤�鿴���ų�Ա
    public List<CommunityCustom> findCommunityList(StudentCustom studentCustom)throws Exception;//����Ա������������
    public void join_community(JoinCommunity joinCommunity)throws Exception;//������������
    public JoinCommunity communityMembers_exist(JoinCommunity joinCommunity)throws Exception;//����ǰ�ж��Ƿ��Ѿ�������
    List<JoinCommunityCustom> findJoinCommunityList(Integer comid);//��������μ����ŵ���

    void updateJoin_Community(JoinCommunity joinCommunity);//����JoinCommunity���е�state

    void insertCommunityMembers(CommunityMembers communityMembers);//��ͨ���ĳ�Ա��ӵ���ʽ��CommunityMembers��

    void deleteCommunityMembers(CommunityMembers communityMembers);//ͨ��stuid��comidɾ�����ų�Ա

    void updateNewProprieter(Integer comid, Integer stuid);

    void addCommunitySubmit(CommunityCustom communityCustom, CommunityMembers communityMembers);

    Community findCommunityById(Integer id);
}
