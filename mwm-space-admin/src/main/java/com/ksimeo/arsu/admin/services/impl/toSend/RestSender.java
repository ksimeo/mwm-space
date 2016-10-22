package com.ksimeo.arsu.admin.services.impl.toSend;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by @author Ksimeo on 14.01.2016 at 16:45. For project: MArsMarketSpace.
 */
public class RestSender {

    private String hostPart;

    public RestSender() {
        hostPart = "http://localhost:8080";
    }

    public RestSender(String hostPart) {
        this.hostPart = hostPart;
    }

    public String doGET(String uri) throws Exception {
        String data = sendGet(hostPart + uri);
        return new String(data.getBytes("cp1251"), "utf-8");
    }

    public String doPOST(String uri, String data) throws Exception {
        System.out.println("Отправляем на " + hostPart + uri);
        data = new String(data.getBytes("utf-8"), "ISO-8859-1");
        String recData = sendPost(hostPart + uri, data);
        return new String(data.getBytes("ISO-8859-1"), "utf-8");
    }


    // HTTP GET request
    private String sendGet(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    // HTTP POST request
    private String sendPost(String url, String data) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(data);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}