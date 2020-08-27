package com.group4.backend.service;

import com.group4.backend.dao.DemoUserDAO;
import com.group4.backend.entity.DemoBond;
import com.group4.backend.entity.DemoUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTest extends AbstractTransactionalJUnit4SpringContextTests {
//public class JunitTest{

    @Autowired
    private DemoBondService demoBondService;
    @Autowired
    private DemoUserService demoUserService;

    @Autowired
    private DemoUserDAO demoUserDAO;


    @Test
    public void testReg(){
        DemoUser testUer = new DemoUser();
        testUer.setId(new BigDecimal(1));
        testUer.setName("2331232@qq.com");
        testUer.setPass("TestBondName11111111111");
        testUer.setCreatedAt(new java.sql.Date(new java.util.Date().getTime()));
        testUer.setUpdatedAt(new java.sql.Date(new java.util.Date().getTime()));
        testUer.setStatus(new BigDecimal(1));
        demoUserService.checkDuplicateUser(testUer);
        assertTrue(demoUserDAO.queryUser(testUer)!=null);
    }

    @Test
    public void testDeleteRecord(){
        DemoBond testRecord = new DemoBond();
        testRecord.setAmount(new BigDecimal(16000));
        testRecord.setId(new BigDecimal(35));
        System.out.print("Test is running");
        demoBondService.deleteRecord(testRecord);
        assertTrue(true);
    }



    @Test
    public void testAddRecord(){
        DemoBond testRecord = new DemoBond();
        testRecord.setAmount(new BigDecimal(6666));
        testRecord.setId(new BigDecimal(10000));
        testRecord.setSaleName("TestSaleName11111111111");
        testRecord.setBondName("TestBondName11111111111");
        testRecord.setCreatedAt(new java.sql.Date(new java.util.Date().getTime()));
        testRecord.setUpdatedAt(new java.sql.Date(new java.util.Date().getTime()));

        List<DemoBond>  retrievedData1 = demoBondService.queryBond(testRecord);
        assertTrue(retrievedData1.size() == 0);

        demoBondService.addRecord(testRecord);
        List<DemoBond>  retrievedData2 = demoBondService.queryBond(testRecord);
        assertTrue(retrievedData2.size() > 0);
    }


}