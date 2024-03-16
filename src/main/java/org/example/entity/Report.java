package org.example.entity;

public class Report {
    String apiName;
    String operationName;
    String apiVersion;
    String responseCode;
    String count;

    public Report(String apiName, String operationName, String apiVersion, String responseCode, String count){
        this.apiName = apiName;
        this.operationName = operationName;
        this.apiVersion = apiVersion;
        this.responseCode = responseCode;
        this.count = count;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Report{" +
                "apiName='" + apiName + '\'' +
                ", operationName='" + operationName + '\'' +
                ", apiVersion='" + apiVersion + '\'' +
                ", responseCode=" + responseCode +
                ", count=" + count +
                '}';
    }
}
