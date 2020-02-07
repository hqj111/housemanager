package com.house.manager.mapper;

import com.house.manager.entity.po.MaintenancePO;
import com.house.manager.entity.po.MaintenancePOCustom;
import com.house.manager.entity.po.MaintenancePOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaintenancePOMapper {

    List<MaintenancePOCustom> selectByExampleByCustom(MaintenancePOExample example);

    int countByExample(MaintenancePOExample example);

    int deleteByExample(MaintenancePOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MaintenancePO record);

    int insertSelective(MaintenancePO record);

    List<MaintenancePO> selectByExampleWithBLOBs(MaintenancePOExample example);

    List<MaintenancePO> selectByExample(MaintenancePOExample example);

    MaintenancePO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MaintenancePO record, @Param("example") MaintenancePOExample example);

    int updateByExampleWithBLOBs(@Param("record") MaintenancePO record, @Param("example") MaintenancePOExample example);

    int updateByExample(@Param("record") MaintenancePO record, @Param("example") MaintenancePOExample example);

    int updateByPrimaryKeySelective(MaintenancePO record);

    int updateByPrimaryKeyWithBLOBs(MaintenancePO record);

    int updateByPrimaryKey(MaintenancePO record);
}