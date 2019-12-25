package cn.itcast.ssm.po;

public class Community {
    private Integer id;

    private String name;

    private Integer presidentid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPresidentid() {
        return presidentid;
    }

    public void setPresidentid(Integer presidentid) {
        this.presidentid = presidentid;
    }
}