package org.example;

import org.example.controller.ReportController;
import org.example.repository.ReportRepository;
import org.example.repository.ReportRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        String fileSuccess = "public/success.csv";
        String fileError = "public/error.csv";
        ReportRepository reportRepository = new ReportRepositoryImpl();
        ReportController reportController = new ReportController(reportRepository);
        reportController.compareReport(fileSuccess, fileError);
    }
}