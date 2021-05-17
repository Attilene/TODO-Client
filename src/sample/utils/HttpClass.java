package sample.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class HttpClass {
    public static String getRequest(String urlString) {
        try {
            URLConnection conn = new URL(urlString).openConnection();
            return getResponse(conn);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String ppdRequest(String urlString, String method, String jsonString) {
        try {
            URLConnection conn = new URL(urlString).openConnection();
            HttpURLConnection http = (HttpURLConnection) conn;
            http.setRequestMethod(method);
            http.setDoOutput(true);

            byte[] out = jsonString.getBytes(StandardCharsets.UTF_8);
            http.setFixedLengthStreamingMode(out.length);
            http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            http.connect();
            try (OutputStream os = http.getOutputStream()) {
                os.write(out);
            }
            return getResponse(conn);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getResponse(URLConnection conn) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStream is = new BufferedInputStream(conn.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String inputLine;
        while ((inputLine = br.readLine()) != null) {
            sb.append(inputLine);
        }
        return sb.toString();
    }
}
