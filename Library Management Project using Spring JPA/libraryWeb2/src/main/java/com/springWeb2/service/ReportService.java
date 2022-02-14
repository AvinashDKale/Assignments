package com.springWeb2.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.repository.IssuedRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private IssuedRepository repository;


//    public String exportReport() throws FileNotFoundException, JRException {
//        String path = "D:\\Report";
//        List<IssuedBookDao> employees = repository.findAll();
//        //load file and compile it
//        File file = ResourceUtils.getFile("classpath:report11.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
//        Map<String, Object> parameters = new HashMap<>();
//        //parameters.put("createdBy", "Java Techie");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Report\\report11.pdf");
//        
//
//        return "report generated in path : " + "D:\\Report";
//    }
    
    public String exportReport() throws FileNotFoundException, JRException {
        String path = "D:\\Report";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("studentName", "avinash");

        List<IssuedBookDao> IBooks = repository.findAll();
        File file = ResourceUtils.getFile("classpath:report11.jrxml");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(IBooks);
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Report\\report11.pdf");
        System.out.println("Report created...");
        return "file is created on D:\\Report";
        }
}