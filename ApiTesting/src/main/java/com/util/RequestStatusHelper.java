package com.util;

import com.sun.tools.javac.util.Assert;
import org.apache.http.HttpResponse;
import org.apache.http.util.Asserts;

public class RequestStatusHelper {

    private static int getStatusCode(HttpResponse response){

        int statusCode = 0;
        if(null != response){
            return response.getStatusLine().getStatusCode();
        }
        return statusCode;
    }

    public static void createStatusCodeValidation(HttpResponse response){

        int EXPECTED = 201;
        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
        Asserts.check(getStatusCode(response) == EXPECTED,"Response Code Mismatch. Expected %s code, actual %s code. ",
                EXPECTED,getStatusCode(response));
    }

    public static void updatetatusValidation(HttpResponse response){

        int EXPECTED = 200;
        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
        Asserts.check(getStatusCode(response) == EXPECTED,"Response Code Mismatch. Expected %s code, actual %s code. ",
                EXPECTED,getStatusCode(response));
    }

    public static void getStatusValidation(HttpResponse response){

        int EXPECTED = 404;
        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
        Asserts.check(getStatusCode(response) == EXPECTED,"Response Code Mismatch. Expected %s code, actual %s code. ",
                EXPECTED,getStatusCode(response));
    }

    public static void deleteStatusValidation(HttpResponse response){

        int EXPECTED = 204;
        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
        Asserts.check(getStatusCode(response) == EXPECTED,"Response Code Mismatch. Expected %s code, actual %s code. ",
                EXPECTED,getStatusCode(response));
    }

}
