package com.crm.service.impl;

import com.crm.beans.PoorVillage;
import com.crm.mapper.PoorVillageMapper;
import com.crm.service.PoorVillageService;
import com.crm.util.responseUtil.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PoorVillageServiceImpl implements PoorVillageService {

    @Autowired
    private PoorVillageMapper poorVillageMapper;


    @Override
    public PageBean<PoorVillage> getPoorVillageList(PoorVillage poorVillage, PageBean page) {

        page.setCurrntPage(page.getCurrntPage() == null ? 1 : (page.getCurrntPage() < 1 ? 1 : page.getCurrntPage()));
        page.setPageSize(page.getPageSize() == null ? PageBean.PAGESIZE : page.getPageSize());
        page.setPageNo((page.getCurrntPage() - 1) * page.getPageSize());
        int count = poorVillageMapper.getPoorVillageListCount(poorVillage);
        List<PoorVillage> poorVillageList = new ArrayList<>();
        if(count > 0){
            poorVillageList = poorVillageMapper.getPoorVillageList(poorVillage, page);
        }
        page.setPageData(poorVillageList);
        page.setTotalCount(count);
        return page;
    }

    @Override
    public int insertSelective(PoorVillage poorVillage) {
        return poorVillageMapper.insertSelective(poorVillage);
    }

    @Override
    public int updateByPrimaryKeySelective(PoorVillage record) {
        return poorVillageMapper.updateByPrimaryKeySelective(record);
    }

}
