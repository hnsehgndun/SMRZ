package com.crm.mapper;

import com.crm.beans.LocationAddress;
import com.crm.beans.LocationAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocationAddressMapper {
    int countByExample(LocationAddressExample example);

    int deleteByExample(LocationAddressExample example);

    int deleteByPrimaryKey(Integer locationId);

    int insert(LocationAddress record);

    int insertSelective(LocationAddress record);

    List<LocationAddress> selectByExample(LocationAddressExample example);

    LocationAddress selectByPrimaryKey(Integer locationId);

    int updateByExampleSelective(@Param("record") LocationAddress record, @Param("example") LocationAddressExample example);

    int updateByExample(@Param("record") LocationAddress record, @Param("example") LocationAddressExample example);

    int updateByPrimaryKeySelective(LocationAddress record);

    int updateByPrimaryKey(LocationAddress record);
}