package com.group4.backend.service;


import com.group4.backend.entity.DemoBond;

import java.util.List;

public interface DemoBondService {
    public List<DemoBond> queryBond(DemoBond condition);
    public void addRecord(DemoBond bondSales);
    public List<DemoBond> orderBySaleName();
    public List<DemoBond> orderByCreated();
    public void deleteRecord(DemoBond bondSales);
    public void modifyRecord(DemoBond bondSales);
}
