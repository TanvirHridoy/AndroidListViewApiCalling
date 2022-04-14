package com.example.myapplication;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public  class AppConst {
    public final  static String rootUrl="http://erp1.bepza.gov.bd:82/api/";
    public final static  String imageUrl=rootUrl+"files/";
    public final  static  String ticket="Ticketes";
    public final static String UserInfo="Userinfs";
    public final  static  String resinf="Resinfs?Rescode=v&Type=Module";
    public static Userinfo user = new Userinfo();
    public static Userinfo getUser() {
        return user;
    }

    public static void setUser(Userinfo user) {
        user.setUserdata(user.getInitJinfo());
        AppConst.user = user;
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
