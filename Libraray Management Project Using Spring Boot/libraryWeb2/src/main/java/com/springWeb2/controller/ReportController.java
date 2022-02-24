package com.springWeb2.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.service.ReportService;
import net.sf.jasperreports.engine.JRException;

@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;
    
    @GetMapping("/issuedbook/report")
    public void generateReport(HttpServletResponse response) throws JRException, IOException {
        reportService.exportPdfReport(response);
    }
    
    @GetMapping(value = "/report/input")
    public String reportInput(Model model) {
        IssuedBookDao book = new IssuedBookDao();
        model.addAttribute("book", book);
        return "reportInput";
    }
    
    @PostMapping("/report/advance")
    public void generateAdvanceReport(@RequestParam(value = "reportName") String reportName,
            @RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate,
            @RequestParam(value = "button") String field, HttpServletResponse response)
            throws JRException, IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        
        reportService.exportAdvanceReport(response, startDate, endDate, reportName, field);
    }
    
    @GetMapping("/report/csv")
    public void exportCSV(HttpServletResponse response) throws Exception {
        
        reportService.exportCsvReport(response);
    }
    
}
