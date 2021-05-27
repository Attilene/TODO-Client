package com.attilene.utils.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public final class HttpClass {
    private HttpClass() {}

    public static String sendGET(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("GET");

            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                System.out.println("Запрос получил код " + con.getResponseCode());
                return null;
            }
        } catch (Exception e) {
            return "500";
        }
    }

    public static String sendPOST_PUT(String urlString, String jsonStr, String method) {
        try {
            URL obj = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod(method);

            con.setDoOutput(true);
            OutputStream stream = con.getOutputStream();
            stream.write(jsonStr.getBytes(StandardCharsets.UTF_8));
            stream.flush();
            stream.close();

            if (con.getResponseCode() == HttpURLConnection.HTTP_CREATED ||
                    con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                System.out.println("Запрос получил код " + con.getResponseCode());
                return null;
            }
        } catch (Exception e) {
            return "500";
        }
    }

    public static String sendDELETE(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");

            if (con.getResponseCode() == HttpURLConnection.HTTP_NO_CONTENT) {
                return "OK";
            } else {
                System.out.println("Запрос получил код " + con.getResponseCode());
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
