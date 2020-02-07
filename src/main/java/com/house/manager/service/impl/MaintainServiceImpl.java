package com.house.manager.service.impl;

import com.house.manager.entity.po.MaintenancePO;
import com.house.manager.entity.po.MaintenancePOCustom;
import com.house.manager.entity.po.MaintenancePOExample;
import com.house.manager.mapper.MaintenancePOMapper;
import com.house.manager.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Create 2020-02-07 8:03
 */
@Service
public class MaintainServiceImpl implements MaintainService {

    @Autowired
    private MaintenancePOMapper maintenancePOMapper;

    @Override
    public List<MaintenancePOCustom> getAllMaintains() {

        MaintenancePOExample maintenancePOExample = new MaintenancePOExample();
        List<MaintenancePOCustom> maintenancePOCustoms = maintenancePOMapper.selectByExampleByCustom(maintenancePOExample);
        for (MaintenancePOCustom maintenancePOCustom : maintenancePOCustoms) {
            System.out.println(maintenancePOCustom.getAppointmentTime());

        }

        return maintenancePOCustoms;
    }

    @Override
    public void modify(MaintenancePO maintenancePO) {
        maintenancePOMapper.updateByPrimaryKey(maintenancePO);
    }

    @Override
    public void delete(Integer id) {
        maintenancePOMapper.deleteByPrimaryKey(id);
    }
}
