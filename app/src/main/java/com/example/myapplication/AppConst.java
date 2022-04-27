package com.example.myapplication;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public  class AppConst {
    public final  static String rootUrl="http://erp1.bepza.gov.bd:82/api/";
    public final static  String imageUrl=rootUrl+"files/";
    public final  static  String ticket="Ticketes";
    public final static String UserInfo="Userinfs";
    public final  static  String resinf="Resinfs";

    public static ArrayList<Ticket> getAdminTickets() {
        return AdminTickets;
    }

    public static void setAdminTickets(ArrayList<Ticket> adminTickets) {
        AdminTickets = adminTickets;
    }

    public static ArrayList<Ticket> getUserTickets() {
        return UserTickets;
    }

    public static void setUserTickets(ArrayList<Ticket> userTickets) {
        UserTickets = userTickets;
    }

    public static ArrayList<Userinfo> getUserLists() {
        return UserLists;
    }

    public static void setUserLists(ArrayList<Userinfo> userLists) {
        UserLists = userLists;
    }

    public static ArrayList<Userinfo> UserLists= new ArrayList<>();
    public static ArrayList<Ticket> AdminTickets= new ArrayList<>();

    public static Ticket getCurrentEditTicket() {
        return CurrentEditTicket;
    }

    public static void setCurrentEditTicket(Ticket currentEditTicket) {
        CurrentEditTicket = currentEditTicket;
    }

    public static Ticket CurrentEditTicket;
    public static ArrayList<Ticket> UserTickets= new ArrayList<>();
    public static ArrayList<Resinf> modules= new ArrayList<>();
    public static ArrayList<Resinf> pages= new ArrayList<>();
    public static ArrayList<Resinf> categories= new ArrayList<>();
    public static ArrayList<Resinf> priorities= new ArrayList<>();
    public static ArrayList<Resinf> types= new ArrayList<>();

    public static ArrayList<Resinf> getStatus() {
        return status;
    }

    public static void setStatus(ArrayList<Resinf> status) {
        AppConst.status = status;
    }

    public static ArrayList<Resinf> status= new ArrayList<>();
    public static LoggedInUser user = new LoggedInUser();

    public static ArrayList<Resinf> getModules() {
        return modules;
    }

    public static void setModules(ArrayList<Resinf> modules) {
        AppConst.modules = modules;
    }

    public static ArrayList<Resinf> getPages() {
        return pages;
    }

    public static void setPages(ArrayList<Resinf> pages) {
        AppConst.pages = pages;
    }

    public static ArrayList<Resinf> getCategories() {
        return categories;
    }

    public static void setCategories(ArrayList<Resinf> categories) {
        AppConst.categories = categories;
    }

    public static ArrayList<Resinf> getPriorities() {
        return priorities;
    }

    public static void setPriorities(ArrayList<Resinf> priorities) {
        AppConst.priorities = priorities;
    }

    public static ArrayList<Resinf> getTypes() {
        return types;
    }

    public static void setTypes(ArrayList<Resinf> types) {
        AppConst.types = types;
    }


    public static LoggedInUser getUser() {
        return user;
    }

    public static void setUser(LoggedInUser u) {
        AppConst.user=u;
        user.setUserdata(u.getInitJinfo());
    }



    public static String getMd5(String input)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
