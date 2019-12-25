package cn.itcast.ssm.po;

import java.util.List;

public class ActivateQueryVo {
    private Activate activate;
    private ActivateCustom activateCustom;
    private List<ActivateCustom> activateCustomList;
    public Activate getActivate() {
        return activate;
    }

    public void setActivate(Activate activate) {
        this.activate = activate;
    }

    public ActivateCustom getActivateCustom() {
        return activateCustom;
    }

    public void setActivateCustom(ActivateCustom activateCustom) {
        this.activateCustom = activateCustom;
    }

    public List<ActivateCustom> getActivateCustomList() {
        return activateCustomList;
    }

    public void setActivateCustomList(List<ActivateCustom> activateCustomList) {
        this.activateCustomList = activateCustomList;
    }
}
