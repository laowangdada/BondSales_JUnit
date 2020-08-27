package com.group4.backend.service.impl;


import com.group4.backend.dao.DemoBondDAO;
import com.group4.backend.entity.DemoBond;

import com.group4.backend.service.DemoBondService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoBondServiceImpl implements DemoBondService {
    @Resource
    DemoBondDAO demoBondDAO;

    @Override
    public List<DemoBond> queryBond(DemoBond condition) {
        //System.out.println("service"+demoBondDAO.queryBond(condition));
        return demoBondDAO.queryBond(condition);
    }

    @Override
    public void addRecord(DemoBond bondSales) {
        demoBondDAO.addRecord(bondSales);
    }

    @Override
    public List<DemoBond> orderBySaleName() {
        return demoBondDAO.orderBySaleName();
    }

    @Override
    public List<DemoBond> orderByCreated() {
        return demoBondDAO.orderByCreated();
    }

    @Override
    public void deleteRecord(DemoBond bondSales){
        demoBondDAO.deleteRecord(bondSales);
    }
    @Override
    public void modifyRecord(DemoBond bondSales){
        demoBondDAO.modifyRecord(bondSales);
    }
}
