package com.example.myapplication;


import java.util.ArrayList;

public class TicketModel {
    float page;
    float per_page;
    float total;

    public ArrayList<Ticket> getData() {
        return data;
    }

    public void setData(ArrayList<Ticket> data) {
        this.data = data;
    }
    public ArrayList<Resinf> getResInfo() {
        return dataResinf;
    }

    public void setResInfo(ArrayList<Resinf> data) {
        this.dataResinf = data;
    }

    float total_pages;
    ArrayList<Ticket> data = new ArrayList<Ticket>();
    ArrayList<Resinf> dataResinf = new ArrayList<Resinf>();
    public class Resinf {
        private String rescode;
        private String resdesc;
        private String restype;
        private String restdes;
        private String resginf = null;
        private String resginfdc = null;
        private float rowid;
        private String rowtime;


        // Getter Methods

        public String getRescode() {
            return rescode;
        }

        public String getResdesc() {
            return resdesc;
        }

        public String getRestype() {
            return restype;
        }

        public String getRestdes() {
            return restdes;
        }

        public String getResginf() {
            return resginf;
        }

        public String getResginfdc() {
            return resginfdc;
        }

        public float getRowid() {
            return rowid;
        }

        public String getRowtime() {
            return rowtime;
        }

        // Setter Methods

        public void setRescode( String rescode ) {
            this.rescode = rescode;
        }

        public void setResdesc( String resdesc ) {
            this.resdesc = resdesc;
        }

        public void setRestype( String restype ) {
            this.restype = restype;
        }

        public void setRestdes( String restdes ) {
            this.restdes = restdes;
        }

        public void setResginf( String resginf ) {
            this.resginf = resginf;
        }

        public void setResginfdc( String resginfdc ) {
            this.resginfdc = resginfdc;
        }

        public void setRowid( float rowid ) {
            this.rowid = rowid;
        }

        public void setRowtime( String rowtime ) {
            this.rowtime = rowtime;
        }
    }
    public class Ticket {
        private String ticketid;
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
        private Userinfo Userinfo;
        private String statusbkp = null;



        // Getter Methods

        public String getTicketid() {
            return ticketid;
        }

        public String getBegintime() {
            return begintime;
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
            return fileurlD;
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
            return Userinfo;
        }

        public String getStatusbkp() {
            return statusbkp;
        }

        // Setter Methods

        public void setTicketid( String ticketid ) {
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
            this.Userinfo= userinfoObject;
        }

        public void setStatusbkp( String statusbkp ) {
            this.statusbkp = statusbkp;
        }
    }

    // Getter Methods

    public float getPage() {
        return page;
    }

    public float getPer_page() {
        return per_page;
    }

    public float getTotal() {
        return total;
    }

    public float getTotal_pages() {
        return total_pages;
    }

    // Setter Methods

    public void setPage( float page ) {
        this.page = page;
    }

    public void setPer_page( float per_page ) {
        this.per_page = per_page;
    }

    public void setTotal( float total ) {
        this.total = total;
    }

    public void setTotal_pages( float total_pages ) {
        this.total_pages = total_pages;
    }
}

//package com.example.myapplication;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ticket {
//    private String ticketid;
//    private String begintime;
//    private String prjitmcode;
//    private String module;
//    private String page;
//    private String ticketdes;
//    private String tickettype;
//    private String tickettypeD;
//    private String tcatagory;
//    private String tcatagoryD;
//    private String fileurl;
//    private String fileurlD;
//    private String expecttime;
//    private String statuscode;
//    private String statuscodeD;
//    private String statustime;
//    private String priority;
//    private String priorityD;
//    private String statusdesc;
//    private String usercode;
//    Userinfo UserinfoObject;
//    private String statusbkp = null;
//
//
//
//    // Getter Methods
//
//    public String getTicketid() {
//        return ticketid;
//    }
//
//    public String getBegintime() {
//        return begintime;
//    }
//
//    public String getPrjitmcode() {
//        return prjitmcode;
//    }
//
//    public String getModule() {
//        return module;
//    }
//
//    public String getPage() {
//        return page;
//    }
//
//    public String getTicketdes() {
//        return ticketdes;
//    }
//
//    public String getTickettype() {
//        return tickettype;
//    }
//
//    public String getTickettypeD() {
//        return tickettypeD;
//    }
//
//    public String getTcatagory() {
//        return tcatagory;
//    }
//
//    public String getTcatagoryD() {
//        return tcatagoryD;
//    }
//
//    public String getFileurl() {
//        return fileurl;
//    }
//
//    public String getFileurlD() {
//        return fileurlD;
//    }
//
//    public String getExpecttime() {
//        return expecttime;
//    }
//
//    public String getStatuscode() {
//        return statuscode;
//    }
//
//    public String getStatuscodeD() {
//        return statuscodeD;
//    }
//
//    public String getStatustime() {
//        return statustime;
//    }
//
//    public String getPriority() {
//        return priority;
//    }
//
//    public String getPriorityD() {
//        return priorityD;
//    }
//
//    public String getStatusdesc() {
//        return statusdesc;
//    }
//
//    public String getUsercode() {
//        return usercode;
//    }
//
//    public Userinfo getUserinfo() {
//        return UserinfoObject;
//    }
//
//    public String getStatusbkp() {
//        return statusbkp;
//    }
//
//    // Setter Methods
//
//    public void setTicketid( String ticketid ) {
//        this.ticketid = ticketid;
//    }
//
//    public void setBegintime( String begintime ) {
//        this.begintime = begintime;
//    }
//
//    public void setPrjitmcode( String prjitmcode ) {
//        this.prjitmcode = prjitmcode;
//    }
//
//    public void setModule( String module ) {
//        this.module = module;
//    }
//
//    public void setPage( String page ) {
//        this.page = page;
//    }
//
//    public void setTicketdes( String ticketdes ) {
//        this.ticketdes = ticketdes;
//    }
//
//    public void setTickettype( String tickettype ) {
//        this.tickettype = tickettype;
//    }
//
//    public void setTickettypeD( String tickettypeD ) {
//        this.tickettypeD = tickettypeD;
//    }
//
//    public void setTcatagory( String tcatagory ) {
//        this.tcatagory = tcatagory;
//    }
//
//    public void setTcatagoryD( String tcatagoryD ) {
//        this.tcatagoryD = tcatagoryD;
//    }
//
//    public void setFileurl( String fileurl ) {
//        this.fileurl = fileurl;
//    }
//
//    public void setFileurlD( String fileurlD ) {
//        this.fileurlD = fileurlD;
//    }
//
//    public void setExpecttime( String expecttime ) {
//        this.expecttime = expecttime;
//    }
//
//    public void setStatuscode( String statuscode ) {
//        this.statuscode = statuscode;
//    }
//
//    public void setStatuscodeD( String statuscodeD ) {
//        this.statuscodeD = statuscodeD;
//    }
//
//    public void setStatustime( String statustime ) {
//        this.statustime = statustime;
//    }
//
//    public void setPriority( String priority ) {
//        this.priority = priority;
//    }
//
//    public void setPriorityD( String priorityD ) {
//        this.priorityD = priorityD;
//    }
//
//    public void setStatusdesc( String statusdesc ) {
//        this.statusdesc = statusdesc;
//    }
//
//    public void setUsercode( String usercode ) {
//        this.usercode = usercode;
//    }
//
//    public void setUserinfo( Userinfo userinfoObject ) {
//        this.UserinfoObject = userinfoObject;
//    }
//
//    public void setStatusbkp( String statusbkp ) {
//        this.statusbkp = statusbkp;
//    }
//}
