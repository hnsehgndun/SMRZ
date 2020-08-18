package com.crm.service.impl;

import com.crm.beans.PoorFamilyInfo;
import com.crm.mapper.PoorFamilyInfoMapper;
import com.crm.service.PoorFamilyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WKX
 */
@Service
public class PoorFamilyInfoServiceImpl implements PoorFamilyInfoService {
    @Autowired
    private PoorFamilyInfoMapper poorFamilyInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer povertyId) {
        return poorFamilyInfoMapper.deleteByPrimaryKey(povertyId);
    }

    @Override
    public int insertSelective(PoorFamilyInfo record) {
        return poorFamilyInfoMapper.insertSelective(record);
    }

    @Override
    public PoorFamilyInfo selectByPrimaryKey(Integer povertyId) {
        return poorFamilyInfoMapper.selectByPrimaryKey(povertyId);
    }

    @Override
    public int updateByPrimaryKeySelective(PoorFamilyInfo record) {
        return poorFamilyInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<PoorFamilyInfo> selectByPage(Integer page, Integer pageSize) {
        int start=(page-1)*pageSize;
        return poorFamilyInfoMapper.selectByPage(start, pageSize);
    }
}
