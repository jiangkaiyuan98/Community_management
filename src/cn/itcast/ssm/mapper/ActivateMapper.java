package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.Activate;
import cn.itcast.ssm.po.ActivateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivateMapper {
    int countByExample(ActivateExample example);

    int deleteByExample(ActivateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Activate record);

    int insertSelective(Activate record);

    List<Activate> selectByExample(ActivateExample example);

    Activate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Activate record, @Param("example") ActivateExample example);

    int updateByExample(@Param("record") Activate record, @Param("example") ActivateExample example);

    int updateByPrimaryKeySelective(Activate record);

    int updateByPrimaryKey(Activate record);
}