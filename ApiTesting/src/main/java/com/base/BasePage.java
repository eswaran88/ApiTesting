package com.base;


import com.util.UrlFormatter;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;

public class BasePage {


    public HttpClient client = HttpClientBuilder.create().build();


    public HttpResponse postRequest(String request) throws IOException {


        HttpPost post = new HttpPost(UrlFormatter.addUserUrlFormat());
        post.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        post.setEntity(new StringEntity(request));


        return client.execute(post);


    }

    public HttpResponse putRequest(String URL, String request) throws IOException {

        System.out.println("URL : ->" + URL);
        HttpPut put = new HttpPut(URL);
        put.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        put.setEntity(new StringEntity(request));


        return client.execute(put);


    }


    public HttpResponse getRequest(String Url) throws IOException {

        System.out.println("URL : -> " + Url);
        HttpGet get = new HttpGet(Url);
        get.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        return client.execute(get);
    }

    public HttpResponse deleteRequest(String Url) throws IOException {

        System.out.println("URL : -> " + Url);
        HttpDelete get = new HttpDelete(Url);
        get.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        return client.execute(get);
    }


    private String getContent(HttpResponse response) throws IOException {
        InputStream stream = response.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.readLine();
    }

    public int getStatusCode(HttpResponse response) {

        if (response != null) {
            return response.getStatusLine().getStatusCode();
        }
        return 0;
    }


}
