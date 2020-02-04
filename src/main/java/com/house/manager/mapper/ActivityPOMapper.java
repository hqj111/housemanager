package com.house.manager.mapper;

import com.house.manager.entity.po.ActivityPO;
import com.house.manager.entity.po.ActivityPOExample;
import com.house.manager.entity.po.ActivityPOKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityPOMapper {
    int countByExample(ActivityPOExample example);

    int deleteByExample(ActivityPOExample example);

    int deleteByPrimaryKey(ActivityPOKey key);

    int insert(ActivityPO record);

    int insertSelective(ActivityPO record);

    List<ActivityPO> selectByExampleWithBLOBs(ActivityPOExample example);

    List<ActivityPO> selectByExample(ActivityPOExample example);

    ActivityPO selectByPrimaryKey(ActivityPOKey key);

    int updateByExampleSelective(@Param("record") ActivityPO record, @Param("example") ActivityPOExample example);

    int updateByExampleWithBLOBs(@Param("record") ActivityPO record, @Param("example") ActivityPOExample example);

    int updateByExample(@Param("record") ActivityPO record, @Param("example") ActivityPOExample example);

    int updateByPrimaryKeySelective(ActivityPO record);

    int updateByPrimaryKeyWithBLOBs(ActivityPO record);

    int updateByPrimaryKey(ActivityPO record);
}