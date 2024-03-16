package org.example.controller;

import org.example.entity.Report;
import org.example.repository.ReportRepository;
import org.example.util.WriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReportController {

    private ReportRepository reportRepository;
    private WriteFile writeFile = new WriteFile();

    public ReportController(ReportRepository reportRepository){
        this.reportRepository = reportRepository;
    }
    public void compareReport(String pathFileSuccess, String pathFileError) {
        List<Report> listSuccess = reportRepository.readCsvSuccess(pathFileSuccess);
        List<Report> listError = reportRepository.readCsvError(pathFileError);
        List<String> repostKibana = new ArrayList<>();

        for(Report error: listError){
            String temp = error.getOperationName();
            for(Report success : listSuccess){
                if(temp.equals(success.getOperationName())){
                    repostKibana.add(success.getApiName() + "/" + success.getApiVersion() + success.getOperationName() + " | " + "Success count : " + success.getCount() + " | Error count : " + error.getCount());
                    break;
                }
            }
        }
        for (String repost: repostKibana){
            System.out.println(repost);
        }
        writeFile.writeReport(repostKibana);
    }
}
