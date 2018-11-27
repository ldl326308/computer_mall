package com.nf.lc.entity;

public class Administrators {
    private Integer adminId;

    private String adminIdNumber;

    private String adminAccountNumber;

    private String adminPassword;

    private String adminSexual;

    private Integer adminAge;

    private Integer adminPowerUser;

    private Integer adminPowerComputer;

    private Integer adminPowerSuperme;

    private Integer adminState;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminIdNumber() {
        return adminIdNumber;
    }

    public void setAdminIdNumber(String adminIdNumber) {
        this.adminIdNumber = adminIdNumber == null ? null : adminIdNumber.trim();
    }

    public String getAdminAccountNumber() {
        return adminAccountNumber;
    }

    public void setAdminAccountNumber(String adminAccountNumber) {
        this.adminAccountNumber = adminAccountNumber == null ? null : adminAccountNumber.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminSexual() {
        return adminSexual;
    }

    public void setAdminSexual(String adminSexual) {
        this.adminSexual = adminSexual == null ? null : adminSexual.trim();
    }

    public Integer getAdminAge() {
        return adminAge;
    }

    public void setAdminAge(Integer adminAge) {
        this.adminAge = adminAge;
    }

    public Integer getAdminPowerUser() {
        return adminPowerUser;
    }

    public void setAdminPowerUser(Integer adminPowerUser) {
        this.adminPowerUser = adminPowerUser;
    }

    public Integer getAdminPowerComputer() {
        return adminPowerComputer;
    }

    public void setAdminPowerComputer(Integer adminPowerComputer) {
        this.adminPowerComputer = adminPowerComputer;
    }

    public Integer getAdminPowerSuperme() {
        return adminPowerSuperme;
    }

    public void setAdminPowerSuperme(Integer adminPowerSuperme) {
        this.adminPowerSuperme = adminPowerSuperme;
    }

    public Integer getAdminState() {
        return adminState;
    }

    public void setAdminState(Integer adminState) {
        this.adminState = adminState;
    }
}