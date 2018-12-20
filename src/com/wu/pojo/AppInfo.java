package com.wu.pojo;

public class AppInfo {

    private Integer id;
    private String softwareName;
    private String APKName;
    private Double softwareSize;
    private String valueNamePingTai;
    private String categoryName1;
    private String categoryName2;
    private String categoryName3;
    private Integer statusId;
    private String valueNameStatus;
    private Integer downloads;
    private String versionNo;

    public AppInfo() {
    }

    public AppInfo(Integer id, String softwareName, String APKName, Double softwareSize, String valueNamePingTai, String categoryName1, String categoryName2, String categoryName3, Integer statusId, String valueNameStatus, Integer downloads, String versionNo) {
        this.id = id;
        this.softwareName = softwareName;
        this.APKName = APKName;
        this.softwareSize = softwareSize;
        this.valueNamePingTai = valueNamePingTai;
        this.categoryName1 = categoryName1;
        this.categoryName2 = categoryName2;
        this.categoryName3 = categoryName3;
        this.statusId = statusId;
        this.valueNameStatus = valueNameStatus;
        this.downloads = downloads;
        this.versionNo = versionNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getAPKName() {
        return APKName;
    }

    public void setAPKName(String APKName) {
        this.APKName = APKName;
    }

    public Double getSoftwareSize() {
        return softwareSize;
    }

    public void setSoftwareSize(Double softwareSize) {
        this.softwareSize = softwareSize;
    }

    public String getValueNamePingTai() {
        return valueNamePingTai;
    }

    public void setValueNamePingTai(String valueNamePingTai) {
        this.valueNamePingTai = valueNamePingTai;
    }

    public String getCategoryName1() {
        return categoryName1;
    }

    public void setCategoryName1(String categoryName1) {
        this.categoryName1 = categoryName1;
    }

    public String getCategoryName2() {
        return categoryName2;
    }

    public void setCategoryName2(String categoryName2) {
        this.categoryName2 = categoryName2;
    }

    public String getCategoryName3() {
        return categoryName3;
    }

    public void setCategoryName3(String categoryName3) {
        this.categoryName3 = categoryName3;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getValueNameStatus() {
        return valueNameStatus;
    }

    public void setValueNameStatus(String valueNameStatus) {
        this.valueNameStatus = valueNameStatus;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    @Override
    public String toString() {
        return "AppInfoToo{" +
                "id=" + id +
                ", softwareName='" + softwareName + '\'' +
                ", APKName='" + APKName + '\'' +
                ", softwareSize=" + softwareSize +
                ", valueNamePingTai='" + valueNamePingTai + '\'' +
                ", categoryName1='" + categoryName1 + '\'' +
                ", categoryName2='" + categoryName2 + '\'' +
                ", categoryName3='" + categoryName3 + '\'' +
                ", statusId=" + statusId +
                ", valueNameStatus='" + valueNameStatus + '\'' +
                ", downloads=" + downloads +
                ", versionNo='" + versionNo + '\'' +
                '}';
    }
}
