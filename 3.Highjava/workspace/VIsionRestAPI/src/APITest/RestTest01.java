package APITest;


import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestTest01 {
    private static final String HOST_URL = "/oauth/authorize?client_id={3a7bedee850fdde6ed60a0e19290a896}&redirect_uri={http://localhost/VIsionRestAPI/Test06.jsp}&response_type=code";

    public void get() {
        HttpURLConnection conn = null;
        JsonObject responseJson = null;

        try {
            URL url = new URL(HOST_URL);

            conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestMethod("GET");
            //conn.setDoOutput(true);

            JsonObject commands = new JsonObject();

            int responseCode = conn.getResponseCode();
            if (responseCode == 400 || responseCode == 401 || responseCode == 500 ) {
                System.out.println(responseCode + " Error!");
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                responseJson = new JsonObject();
                System.out.println(responseJson);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}