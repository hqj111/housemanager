package com.house.manager.service;

import com.house.manager.entity.po.MaintenancePO;
import com.house.manager.entity.po.MaintenancePOCustom;

import java.util.List;

/**
 * @Create 2020-02-07 8:02
 */
public interface MaintainService {

    List<MaintenancePOCustom> getAllMaintains();

    void modify(MaintenancePO maintenancePO);

    void delete(Integer id);
}
