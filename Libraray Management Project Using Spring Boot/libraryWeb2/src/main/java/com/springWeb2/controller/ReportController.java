package com.springWeb2.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.service.IssuedServiceImpl;
import com.springWeb2.service.ReportService;
import net.sf.jasperreports.engine.JRException;

@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;
    
    @Autowired
    private IssuedServiceImpl issuedService;
    
    @GetMapping("/issuedbook/report")
    public void generateReport(HttpServletResponse response) throws JRException, IOException {
        reportService.exportReport(response);
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
            HttpServletResponse response) throws JRException, IOException {
        System.out.println(startDate + endDate);
        reportService.exportAdvanceReport(response, startDate, endDate, reportName);
    }
    
//    @PostMapping("/csvReport")
//    public void exportToCSV(@RequestParam(value = "reportName") String reportName,
//            @RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate,
//            HttpServletResponse response) throws JRException, IOException {
//        System.out.println(startDate + endDate);
//        reportService.exportToCSV(response, startDate, endDate, reportName);
//    }    
    
    @GetMapping("/report/csv")
    public void exportCSV(HttpServletResponse response) throws Exception {
        
        String filename = "report.csv";
        
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");
        
        StatefulBeanToCsv<IssuedBookDao> writer = new StatefulBeanToCsvBuilder<IssuedBookDao>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false).build();
        
        writer.write(issuedService.findAllBooks());
        
    }
    
}
