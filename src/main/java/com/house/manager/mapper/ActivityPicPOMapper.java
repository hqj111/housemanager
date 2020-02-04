package com.house.manager.mapper;

import com.house.manager.entity.po.ActivityPicPO;
import com.house.manager.entity.po.ActivityPicPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityPicPOMapper {
    int countByExample(ActivityPicPOExample example);

    int deleteByExample(ActivityPicPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityPicPO record);

    int insertSelective(ActivityPicPO record);

    List<ActivityPicPO> selectByExample(ActivityPicPOExample example);

    ActivityPicPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivityPicPO record, @Param("example") ActivityPicPOExample example);

    int updateByExample(@Param("record") ActivityPicPO record, @Param("example") ActivityPicPOExample example);

    int updateByPrimaryKeySelective(ActivityPicPO record);

    int updateByPrimaryKey(ActivityPicPO record);
}