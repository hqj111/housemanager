package com.house.manager.mapper;

import com.house.manager.entity.po.NeedPO;
import com.house.manager.entity.po.NeedPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NeedPOMapper {
    int countByExample(NeedPOExample example);

    int deleteByExample(NeedPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NeedPO record);

    int insertSelective(NeedPO record);

    List<NeedPO> selectByExampleWithBLOBs(NeedPOExample example);

    List<NeedPO> selectByExample(NeedPOExample example);

    NeedPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NeedPO record, @Param("example") NeedPOExample example);

    int updateByExampleWithBLOBs(@Param("record") NeedPO record, @Param("example") NeedPOExample example);

    int updateByExample(@Param("record") NeedPO record, @Param("example") NeedPOExample example);

    int updateByPrimaryKeySelective(NeedPO record);

    int updateByPrimaryKeyWithBLOBs(NeedPO record);

    int updateByPrimaryKey(NeedPO record);
}