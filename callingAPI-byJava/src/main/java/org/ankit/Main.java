package org.ankit;

import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        String urlString = "https://api.zippopotam.us/us/33162";

        URL url =null;
        HttpURLConnection connection =null;
        int responseCode =0;

        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println("error");
        }

        try {
            connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            System.out.println("error");
        }
        if(responseCode==200){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String ReadLine =null;

            while((ReadLine =in.readLine())!=null){
                apiData.append(ReadLine);
            }
            in.close();


            JSONObject jsonApiResponse = new JSONObject(apiData.toString());
            System.out.println(jsonApiResponse);
        }
        else{
            System.out.println("invailed API"+responseCode);
        }

    }
}