package com.util;

public class UrlFormatter {

    private static final String BASEURL = "https://reqres.in/";
    private static StringBuffer actualUrl = new StringBuffer();


    public static String addUserUrlFormat(){

        actualUrl.setLength(0);
        return actualUrl.append(BASEURL).append("api/users/").toString();

    }

    public static String updateUrlFormat(String userId){

        actualUrl.setLength(0);
        return actualUrl.append(BASEURL).append("api/users/").append(userId).toString();

    }

    public static String deleteUserUrlFormat(String userId){

        actualUrl.setLength(0);
        return actualUrl.append(BASEURL).append("api/users/").append(userId).toString();

    }


    public static String readUserUrlFormat(String userId){

        actualUrl.setLength(0);
        return actualUrl.append(BASEURL).append("api/unknown/").append(userId).toString();

    }
}
