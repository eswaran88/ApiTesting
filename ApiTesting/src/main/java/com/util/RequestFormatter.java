package com.util;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RequestFormatter
{

    private static RequestFormatter requestFormatter;
    private static Gson gson;

    public static RequestFormatter requestFormatter(){
        if(null == requestFormatter || null == gson){
            requestFormatter = new RequestFormatter();
            gson = new Gson();
        }
        return requestFormatter;
    }


    public static String objectToString(Object object,Class cls){
        System.out.println("Request -> \n"+gson.toJson(object,cls));
        return gson.toJson(object,cls);
    }

    public static Object stringToObject(String response,Class cls){
        System.out.println("Response : --> \n" + response);
        return gson.fromJson(response,cls);
    }

    public static Object responseToObject(HttpResponse response,Class cls){

        return stringToObject(getContent(response),cls);

    }

    private static String getContent(HttpResponse response)  {
        try {

            InputStream stream = response.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            return reader.readLine();

        }catch (Exception e){
            System.out.println("Error : " + e);
        }

        return null;

    }

}
