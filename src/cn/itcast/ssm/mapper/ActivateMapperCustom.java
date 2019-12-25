package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.ActivateCustom;

import java.util.List;

public interface ActivateMapperCustom {
    public List<ActivateCustom> findActivateList(Integer id)throws Exception;
}
