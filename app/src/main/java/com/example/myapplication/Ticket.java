package com.example.myapplication;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private int ticketid;
    private String begintime;
    private String prjitmcode;
    private String module;
    private String page;
    private String ticketdes;
    private String tickettype;
    private String tickettypeD;
    private String tcatagory;
    private String tcatagoryD;
    private String fileurl;
    private String fileurlD;
    private String expecttime;
    private String statuscode;
    private String statuscodeD;
    private String statustime;
    private String priority;
    private String priorityD;
    private String statusdesc;
    private String usercode;

//        public void setUserinfo(String userinfo) {
//            this.userinfo = userinfo;
//        }

    //private  String userinfo;
    private Userinfo userinfo;
    private String statusbkp = null;

    public Ticket(int ticketid) {
        this.ticketid = ticketid;
    }


    // Getter Methods

    public int getTicketid() {
        return ticketid;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getBegintime() {

        LocalDateTime dateTime = LocalDateTime.parse(this.begintime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a");
        return dateTime.format(formatter);
    }

    public String getPrjitmcode() {
        return prjitmcode;
    }

    public String getModule() {
        return module;
    }

    public String getPage() {
        return page;
    }

    public String getTicketdes() {
        return ticketdes;
    }

    public String getTickettype() {
        return tickettype;
    }

    public String getTickettypeD() {
        return tickettypeD;
    }

    public String getTcatagory() {
        return tcatagory;
    }

    public String getTcatagoryD() {
        return tcatagoryD;
    }

    public String getFileurl() {
        return fileurl;
    }

    public String getFileurlD() {
        return this.fileurlD;
    }

    public String getExpecttime() {
        return expecttime;
    }

    public String getStatuscode() {
        return statuscode;
    }

    public String getStatuscodeD() {
        return statuscodeD;
    }

    public String getStatustime() {
        return statustime;
    }

    public String getPriority() {
        return priority;
    }

    public String getPriorityD() {
        return priorityD;
    }

    public String getStatusdesc() {
        return statusdesc;
    }

    public String getUsercode() {
        return usercode;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public String getStatusbkp() {
        return statusbkp;
    }

    // Setter Methods

    public void setTicketid( int ticketid ) {
        this.ticketid = ticketid;
    }

    public void setBegintime( String begintime ) {
        this.begintime = begintime;
    }

    public void setPrjitmcode( String prjitmcode ) {
        this.prjitmcode = prjitmcode;
    }

    public void setModule( String module ) {
        this.module = module;
    }

    public void setPage( String page ) {
        this.page = page;
    }

    public void setTicketdes( String ticketdes ) {
        this.ticketdes = ticketdes;
    }

    public void setTickettype( String tickettype ) {
        this.tickettype = tickettype;
    }

    public void setTickettypeD( String tickettypeD ) {
        this.tickettypeD = tickettypeD;
    }

    public void setTcatagory( String tcatagory ) {
        this.tcatagory = tcatagory;
    }

    public void setTcatagoryD( String tcatagoryD ) {
        this.tcatagoryD = tcatagoryD;
    }

    public void setFileurl( String fileurl ) {
        this.fileurl = fileurl;
    }

    public void setFileurlD( String fileurlD ) {
        this.fileurlD = fileurlD;
    }

    public void setExpecttime( String expecttime ) {
        this.expecttime = expecttime;
    }

    public void setStatuscode( String statuscode ) {
        this.statuscode = statuscode;
    }

    public void setStatuscodeD( String statuscodeD ) {
        this.statuscodeD = statuscodeD;
    }

    public void setStatustime( String statustime ) {
        this.statustime = statustime;
    }

    public void setPriority( String priority ) {
        this.priority = priority;
    }

    public void setPriorityD( String priorityD ) {
        this.priorityD = priorityD;
    }

    public void setStatusdesc( String statusdesc ) {
        this.statusdesc = statusdesc;
    }

    public void setUsercode( String usercode ) {
        this.usercode = usercode;
    }

    public void setUserinfo( Userinfo userinfoObject ) {
        this.userinfo= userinfoObject;
    }

    public void setStatusbkp( String statusbkp ) {
        this.statusbkp = statusbkp;
    }
}
