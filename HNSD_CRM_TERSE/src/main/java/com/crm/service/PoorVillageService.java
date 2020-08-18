package com.crm.service;

import com.crm.beans.PoorVillage;
import com.crm.util.responseUtil.PageBean;

public interface PoorVillageService {

    PageBean<PoorVillage> getPoorVillageList(PoorVillage poorVillage, PageBean page);

    int insertSelective(PoorVillage poorVillage);

}
