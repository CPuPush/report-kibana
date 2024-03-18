package org.example.repository;

import org.example.entity.Report;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportRepositoryImpl implements ReportRepository {
    @Override
    public List<Report> readCsvSuccess(String filePath) {
        List<Report> reports = new ArrayList<>();
        String line = "";
        String splitCsv = ",";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            while ((line = br.readLine()) != null){
                String[] data = line.split(splitCsv);
                // Menghapus tanda kutip ganda dari setiap elemen data jika ada
                for (int i = 0; i < data.length; i++) {
                    data[i] = data[i].replace("\"", "");
                }
                String apiName = data[0];
                String operationName = data[1];
                String apiVersion = data[2];
                String responseCode = data[3];
                String count = data[4];
                reports.add(new Report(apiName, operationName, apiVersion, responseCode, count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reports;
    }

    @Override
    public List<Report> readCsvError(String filePath) {
        List<Report> reports = new ArrayList<>();
        String line = "";
        String splitCsv = ",";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            while ((line = br.readLine()) != null){
                String[] data = line.split(splitCsv);
//                API Name,API Version,Response Code,operationName: Descending,Count
//                String apiName = data[0];
//                String operationName = data[2];
//                String apiVersion = data[1];
//                String responseCode = data[4];
//                String count = data[3];
                for (int i = 0; i < data.length; i++) {
                    data[i] = data[i].replace("\"", "");
                }
                String apiName = data[0];
                String operationName = data[3];
                String apiVersion = data[1];
                String responseCode = data[2];
                String count = data[4];
                reports.add(new Report(apiName, operationName, apiVersion, responseCode, count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reports;
    }
}
