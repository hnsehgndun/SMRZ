package com.crm.service.impl;

import com.crm.beans.PoorFamilyHelpNeeds;
import com.crm.mapper.PoorFamilyHelpNeedsMapper;
import com.crm.service.PoorFamilyHelpNeedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WKX
 */
@Service
public class PoorFamilyHelpNeedsServiceImpl implements PoorFamilyHelpNeedsService {
    @Autowired
    private PoorFamilyHelpNeedsMapper poorFamilyHelpNeedsMapper;


    @Override
    public int deleteByPrimaryKey(Integer nId) {
        return poorFamilyHelpNeedsMapper.deleteByPrimaryKey(nId);
    }

    @Override
    public int insert(PoorFamilyHelpNeeds record) {
        return poorFamilyHelpNeedsMapper.insert(record);
    }

    @Override
    public int insertSelective(PoorFamilyHelpNeeds record) {
        return poorFamilyHelpNeedsMapper.insertSelective(record);
    }

    @Override
    public PoorFamilyHelpNeeds selectByPrimaryKey(Integer nId) {
        return poorFamilyHelpNeedsMapper.selectByPrimaryKey(nId);
    }

    @Override
    public int updateByPrimaryKeySelective(PoorFamilyHelpNeeds record) {
        return poorFamilyHelpNeedsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PoorFamilyHelpNeeds record) {
        return poorFamilyHelpNeedsMapper.updateByPrimaryKey(record);
    }
}
