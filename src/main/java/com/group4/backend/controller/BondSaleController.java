package com.group4.backend.controller;

import com.group4.backend.entity.DemoBond;
import com.group4.backend.service.DemoBondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("BondSaleCtrl")
public class BondSaleController {
    @Autowired
    private DemoBondService demoBondService;

    @RequestMapping("/querybond")
    @ResponseBody
    public List<DemoBond> queryBond(@RequestParam("bondName") String bondName,
                                    @RequestParam("saleName") String saleName,
                                    @RequestParam("createdAt") String createdAt,
                                    @RequestParam("amount") BigDecimal amount,
                                    Model model) throws ParseException {
        //System.out.println("ctrl"+demoBondService.queryBond(condition));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date newCreatedAt = sdf.parse(createdAt);
        java.sql.Date dayDateSql = new java.sql.Date(newCreatedAt.getTime());
        DemoBond demoBond = new DemoBond();
        demoBond.setAmount(amount);
        demoBond.setSaleName(saleName);
        demoBond.setBondName(bondName);
        demoBond.setCreatedAt(dayDateSql);
        return demoBondService.queryBond(demoBond);
    }

    @RequestMapping("/ordersale")
    @ResponseBody
    public List<DemoBond> orderBySaleName() {
        //System.out.println("ctrl"+demoBondService.orderBySaleName());
        return demoBondService.orderBySaleName();
    }

    @RequestMapping("/orderdate")
    @ResponseBody
    public List<DemoBond> orderByCreated() {
        return demoBondService.orderByCreated();
    }

    @PostMapping("addRecord")
    @ResponseBody
    public String login(@RequestBody DemoBond bondSales, HttpServletRequest request) {
        try {
            demoBondService.addRecord(bondSales);
        }
        catch(Exception e){
            return "Invalid Record!";
        }
        return "Recorded Correctly!";
    }

    @PostMapping("deleteRecord")
    @ResponseBody
    public String deleteRecord(@RequestBody DemoBond bondSales, HttpServletRequest request) {
        try {
            demoBondService.deleteRecord(bondSales);
        }
        catch(Exception e){
            return "Failed to delete record!";
        }
        return "Deleted Correctly!";
    }

    @PostMapping("modifyRecord")
    @ResponseBody
    public String modifyRecord(@RequestBody DemoBond bondSales, HttpServletRequest request) {
        try {
            demoBondService.modifyRecord(bondSales);
        }
        catch(Exception e){
            return "Failed to modify record!";
        }
        return "Modified Correctly!";
    }

}
