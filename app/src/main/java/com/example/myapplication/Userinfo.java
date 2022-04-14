package com.example.myapplication;

import com.google.gson.Gson;

public class Userinfo {
    private String rescode;
    private String loginid;
    private String paword;
    private String rmrks;
    private String imageurl;

    public boolean isIsactive() {
        return isactive;
    }

    private boolean isactive;

    public String getInitJinfo() {
        return initJinfo;
    }

    private String initJinfo;

    public InitJinfo getUserdata() {
        return userdata;
    }

    public void setUserdata(String userdata) {
       Gson g= new Gson();
        this.userdata =g.fromJson(userdata,InitJinfo.class);
    }

    private InitJinfo userdata;
    public static Userinfo User = new Userinfo();



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
