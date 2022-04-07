package com.example.myapplication;

public class Userinfo {
    private String rescode;
    private String loginid;
    private String paword;
    private String rmrks;
    private String imageurl;
    private boolean isactive;
    private String initJinfo;


    // Getter Methods

    public String getRescode() {
        return rescode;
    }

    public String getLoginid() {
        return loginid;
    }

    public String getPaword() {
        return paword;
    }

    public String getRmrks() {
        return rmrks;
    }

    public String getImageurl() {
        return imageurl;
    }

    public boolean getIsactive() {
        return isactive;
    }

    public String getInitJinfo() {
        return initJinfo;
    }

    // Setter Methods

    public void setRescode( String rescode ) {
        this.rescode = rescode;
    }

    public void setLoginid( String loginid ) {
        this.loginid = loginid;
    }

    public void setPaword( String paword ) {
        this.paword = paword;
    }

    public void setRmrks( String rmrks ) {
        this.rmrks = rmrks;
    }

    public void setImageurl( String imageurl ) {
        this.imageurl = imageurl;
    }

    public void setIsactive( boolean isactive ) {
        this.isactive = isactive;
    }

    public void setInitJinfo( String initJinfo ) {
        this.initJinfo = initJinfo;
    }
}
