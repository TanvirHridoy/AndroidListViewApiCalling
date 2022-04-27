package com.example.myapplication;

import com.google.gson.Gson;

public class LoggedInUser {
    private String Rescode;
    private String Loginid;
    private String Paword;
    private String Rmrks;
    private String Imageurl;
    private boolean Isactive;
    private String InitJinfo;
    private InitJinfo userdata;


    // Getter Methods

    public String getRescode() {
        return Rescode;
    }

    public String getLoginid() {
        return Loginid;
    }

    public String getPaword() {
        return Paword;
    }

    public String getRmrks() {
        return Rmrks;
    }

    public String getImageurl() {
        return Imageurl;
    }

    public boolean getIsactive() {
        return Isactive;
    }

    public String getInitJinfo() {
        return InitJinfo;
    }

    // Setter Methods

    public void setRescode(String Rescode) {
        this.Rescode = Rescode;
    }

    public void setLoginid(String Loginid) {
        this.Loginid = Loginid;
    }

    public void setPaword(String Paword) {
        this.Paword = Paword;
    }

    public void setRmrks(String Rmrks) {
        this.Rmrks = Rmrks;
    }

    public void setImageurl(String Imageurl) {
        this.Imageurl = Imageurl;
    }

    public void setIsactive(boolean Isactive) {
        this.Isactive = Isactive;
    }

    public void setInitJinfo(String InitJinfo) {
        setUserdata(InitJinfo);
        this.InitJinfo = InitJinfo;
    }

    public InitJinfo getUserdata() {
        setUserdata(this.InitJinfo);
        return userdata;
    }

    public void setUserdata(String userdata) {
        Gson g= new Gson();
        this.userdata =g.fromJson(userdata,InitJinfo.class);
    }
}