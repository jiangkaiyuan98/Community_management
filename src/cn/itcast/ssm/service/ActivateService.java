package cn.itcast.ssm.service;

import cn.itcast.ssm.po.*;

import java.util.List;

public interface ActivateService {
    public List<ActivateCustom> findActivateList(Integer id)throws Exception;
    public void insertActivate(Activate activate)throws Exception;
    public void deleteByPrimaryKey(Integer id)throws Exception;
    public void updateByPrimaryKey(ActivateQueryVo activateQueryVo)throws Exception;
    public Integer join_act_num(Integer stu_id,Integer com_id)throws Exception;//ѧ���������Ż����Ŀ
    public void join_activate_cache(JoinActivityMembers joinActivityMembers)throws Exception;//������������
    public JoinActivityMembers join_activateMembers_exist(JoinActivityMembers joinActivityMembers)throws Exception;//����ǰ�ж��Ƿ��Ѿ�������
    public List<JoinActivityMembersCustom> find_all_join_activityMembersList(Integer act_id)throws Exception;//�������б����μ�idΪact_id����
    public void updateJoin_act_Members(JoinActivityMembers joinActivityMembers)throws Exception;//update joinactMembers�ı�����state
    public void insertAvtivityMembers(ActivityMembers activityMembers)throws Exception;//ͨ����˼��뵽��ʽ��
    List<ActivityMembersCustom> findActivityMembers(Integer activateid);//���һ��Ա
    void deleteByPrimaryKey_ActivityMembers(Integer id)throws Exception;//��������ɾ�����Ա
}
