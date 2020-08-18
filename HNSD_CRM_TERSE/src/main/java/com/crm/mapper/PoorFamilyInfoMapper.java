package com.crm.mapper;

import com.crm.beans.PoorFamilyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PoorFamilyInfoMapper {
    int deleteByPrimaryKey(Integer pfId);

    int insert(PoorFamilyInfo record);

    int insertSelective(PoorFamilyInfo record);

    PoorFamilyInfo selectByPrimaryKey(Integer pfId);

    int updateByPrimaryKeySelective(PoorFamilyInfo record);

    int updateByPrimaryKey(PoorFamilyInfo record);

    List<PoorFamilyInfo> selectByPage(@Param("start") Integer start, @Param("size") Integer size);
}