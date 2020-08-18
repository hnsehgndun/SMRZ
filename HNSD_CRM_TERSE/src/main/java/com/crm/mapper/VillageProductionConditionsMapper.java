package com.crm.mapper;

import com.crm.beans.VillageProductionConditions;

public interface VillageProductionConditionsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(VillageProductionConditions record);

    int insertSelective(VillageProductionConditions record);

    VillageProductionConditions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VillageProductionConditions record);

    int updateByPrimaryKey(VillageProductionConditions record);
}