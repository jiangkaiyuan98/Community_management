package cn.itcast.ssm.po;

import java.util.List;

public class CommunityQueryVo {
    Community community;
    CommunityCustom communityCustom;
    List<CommunityCustom> communityCustomList;

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public CommunityCustom getCommunityCustom() {
        return communityCustom;
    }

    public void setCommunityCustom(CommunityCustom communityCustom) {
        this.communityCustom = communityCustom;
    }

    public List<CommunityCustom> getCommunityCustomList() {
        return communityCustomList;
    }

    public void setCommunityCustomList(List<CommunityCustom> communityCustomList) {
        this.communityCustomList = communityCustomList;
    }
}
