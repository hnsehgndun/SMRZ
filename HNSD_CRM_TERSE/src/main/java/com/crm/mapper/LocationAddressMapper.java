package com.crm.mapper;

import com.crm.beans.LocationAddress;

public interface LocationAddressMapper {
    int deleteByPrimaryKey(Integer locationId);

    int insert(LocationAddress record);

    int insertSelective(LocationAddress record);

    LocationAddress selectByPrimaryKey(Integer locationId);

    int updateByPrimaryKeySelective(LocationAddress record);

    int updateByPrimaryKey(LocationAddress record);
}