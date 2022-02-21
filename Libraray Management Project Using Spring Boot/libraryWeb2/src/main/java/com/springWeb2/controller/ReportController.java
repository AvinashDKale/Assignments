package com.springWeb2.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.service.ReportService;
import net.sf.jasperreports.engine.JRException;

@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;
    
    @GetMapping("/report")
    public void generateReport(HttpServletResponse response) throws JRException, IOException {
        reportService.exportReport(response);
    }
    
    @GetMapping(value = "/reportInput")
    public String reportInput(Model model) {
        IssuedBookDao book = new IssuedBookDao();
        model.addAttribute("book", book);
        return "reportInput";
    }
    
    @PostMapping("/reportPage")
    public void generateAdvanceReport(@RequestParam(value = "reportName") String reportName,
            @RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate,
            HttpServletResponse response) throws JRException, IOException {
        System.out.println(startDate + endDate);
        reportService.exportAdvanceReport(response, startDate, endDate, reportName);
    }
    
    @PostMapping("/csvReport")
    public void exportToCSV(@RequestParam(value = "reportName") String reportName,
            @RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate,
            HttpServletResponse response) throws JRException, IOException {
        System.out.println(startDate + endDate);
        reportService.exportToCSV(response, startDate, endDate, reportName);
    }    
}
