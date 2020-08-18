package com.crm.service.impl;

import com.crm.beans.NaturalVillage;
import com.crm.mapper.NaturalVillageMapper;
import com.crm.service.NaturalVillageService;
import com.crm.util.responseUtil.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NaturalVillageServiceImpl implements NaturalVillageService {

    @Autowired
    private NaturalVillageMapper naturalVillageMapper;


    @Override
    public PageBean<NaturalVillage> getNaturalVillageList(NaturalVillage naturalVillage, PageBean page) {

        page.setCurrntPage(page.getCurrntPage() == null ? 1 : (page.getCurrntPage() < 1 ? 1 : page.getCurrntPage()));
        page.setPageSize(page.getPageSize() == null ? PageBean.PAGESIZE : page.getPageSize());
        page.setPageNo((page.getCurrntPage() - 1) * page.getPageSize());
        List<NaturalVillage> poorVillageList = new ArrayList<>();
        int count = naturalVillageMapper.getNaturalVillageListCount(naturalVillage);
        if(count > 0){
            poorVillageList = naturalVillageMapper.getNaturalVillageList(naturalVillage, page);
        }

        page.setPageData(poorVillageList);
        page.setTotalCount(count);
        return page;
    }

    @Override
    public int insertSelective(NaturalVillage naturalVillage) {
        return naturalVillageMapper.insertSelective(naturalVillage);
    }

    @Override
    public NaturalVillage selectByPrimaryKey(Integer naturalVillageId) {
        return naturalVillageMapper.selectByPrimaryKey(naturalVillageId);
    }

    @Override
    public int updateByPrimaryKeySelective(NaturalVillage record) {
        return naturalVillageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int checkOnlyNaturalVillage(NaturalVillage naturalVillage) {
        return naturalVillageMapper.getNaturalVillageListCount(naturalVillage);
    }

    @Override
    public int checkOnlyUpdateNaturalVillageCode(NaturalVillage naturalVillage) {
        return naturalVillageMapper.checkOnlyUpdateNaturalVillageCode(naturalVillage);
    }

    @Override
    public int deleteByPrimaryKey(Integer naturalVillageId) {
        return naturalVillageMapper.deleteByPrimaryKey(naturalVillageId);
    }

}
