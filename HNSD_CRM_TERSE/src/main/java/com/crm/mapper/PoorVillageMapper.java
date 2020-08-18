package com.crm.mapper;

import com.crm.beans.PoorVillage;
import com.crm.util.responseUtil.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoorVillageMapper {

    int deleteByPrimaryKey(Integer villageId);

    int insert(PoorVillage record);

    int insertSelective(PoorVillage record);

    PoorVillage selectByPrimaryKey(Integer villageId);

    int updateByPrimaryKeySelective(PoorVillage record);

    int updateByPrimaryKey(PoorVillage record);

    List<PoorVillage> getPoorVillageList(@Param("poorVillage") PoorVillage poorVillage, @Param("page") PageBean page);

    int getPoorVillageListCount(@Param("poorVillage") PoorVillage poorVillage);
}