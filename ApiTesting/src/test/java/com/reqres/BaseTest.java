package com.reqres;

import com.base.BasePage;
import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BaseTest extends BasePage {

    public  String getContent(HttpResponse response)  {
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
