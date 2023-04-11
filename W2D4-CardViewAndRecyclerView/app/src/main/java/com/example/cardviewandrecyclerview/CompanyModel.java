package com.example.cardviewandrecyclerview;

import java.io.Serializable;

public class CompanyModel implements Serializable {

    private String companyName;
    private String companyYear;
    private int companyLogo;

    public CompanyModel(String companyName, String companyYear, int companyLogo) {
        this.companyName = companyName;
        this.companyYear = companyYear;
        this.companyLogo = companyLogo;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyYear() {
        return companyYear;
    }

    public void setCompanyYear(String companyYear) {
        this.companyYear = companyYear;
    }

    public int getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(int companyLogo) {
        this.companyLogo = companyLogo;
    }


}
