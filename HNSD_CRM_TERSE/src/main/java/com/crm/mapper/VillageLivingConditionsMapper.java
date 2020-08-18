package com.crm.mapper;

import com.crm.beans.VillageLivingConditions;

public interface VillageLivingConditionsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(VillageLivingConditions record);

    int insertSelective(VillageLivingConditions record);

    VillageLivingConditions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VillageLivingConditions record);

    int updateByPrimaryKey(VillageLivingConditions record);
}