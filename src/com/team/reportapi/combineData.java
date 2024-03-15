package com.team.reportapi;

import java.io.*;
import java.util.*;

public class combineData {
    public static void main(String[] args) throws IOException {
        String csvFile1 = "D:\\Project\\2022\\SOA Gov\\report\\table.csv";
        String csvFile2 = "D:\\Project\\2022\\SOA Gov\\report\\table1.csv";
        String outputCSV = "D:\\Project\\2022\\SOA Gov\\report\\report.csv";

        Map<String, List<String>> csvData1 = readCSV(csvFile1);
        Map<String, List<String>> csvData2 = readCSV(csvFile2);

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputCSV));

        // Menulis header
        writer.write("Combined Data");
        writer.newLine();

        // Menggabungkan data dari kedua file CSV
        for (String key : csvData1.keySet()) {
            List<String> data1 = csvData1.get(key);
            List<String> data2 = csvData2.get(key);

            // Menghapus kolom yang sama
            data2.removeAll(data1);
            List<String> combinedData = new ArrayList<>();
            combinedData.addAll(data1);
            combinedData.addAll(data2);

            writer.write(String.join(",", combinedData));
            writer.newLine();
        }

        writer.close();
    }

    private static Map<String, List<String>> readCSV(String csvFile) throws IOException {
        Map<String, List<String>> csvData = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            csvData.put(data[0], Arrays.asList(data));
        }

        reader.close();
        return csvData;
    }
}
