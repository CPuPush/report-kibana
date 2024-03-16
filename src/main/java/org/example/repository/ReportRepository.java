package org.example.repository;

import org.example.entity.Report;

import java.util.List;

public interface ReportRepository {
    List<Report> readCsvSuccess(String filePath);
    List<Report> readCsvError(String filePath);
}
