// 
// Decompiled by Procyon v0.5.36
// 

package com.z.api.client;

import org.json.JSONObject;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class main_sms_client
{
    public static String sendSms(final String sender, final String receiver, final String msgid, final String message) {
        HttpURLConnection connection = null;
        String ret = "";
        try {
            String line = "";
            final URL url = new URL("https://api.sms.rw/");
            connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(50000);
            connection.setReadTimeout(50000);
            String parameters = "client=domestic&";
            parameters = parameters + "password=6r7n1k&ohereza=" + sender + "&kuri=" + receiver + "&cellurl=https://gateway.esicia.com/dlr/&ubutumwa=" + message + "&messagetype=txt&msgid=" + msgid + "&retype=json";
            final OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(parameters);
            writer.flush();
            final StringBuffer responseContent = new StringBuffer();
            System.out.println("Ok");
            final BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.println("Output");
            if (connection.getResponseCode() > 299) {
                final BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = br.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            else {
                final BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = br.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            ret = parse(responseContent.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            connection.disconnect();
        }
        return ret;
    }
    
    public static void main(final String[] args) {
        System.out.println(sendSms("akili", "250788370013", "1121", "Hello Bona, Bite se waje skype. Thanks"));
    }
    
    public static String parse(final String jsonS) {
        final JSONObject album = new JSONObject(jsonS);
        System.out.println(album);
        final int success = album.getInt("success");
        System.out.println(album.get("message"));
        final String message = album.getString("message");
        final String msgid = album.getString("msgid");
        final int balance = album.getInt("balance");
        System.out.println("Success:" + success + ",message:" + message + ",balance:" + balance + ">>>:" + msgid);
        return message;
    }
}
