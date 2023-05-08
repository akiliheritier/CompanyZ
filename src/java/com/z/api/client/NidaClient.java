
package com.z.api.client;
 

 
 
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;

public class NidaClient {

    public static NidaDataResponse validateNID(final String nid) {
        HttpURLConnection connection = null;
        NidaDataResponse ret = null;
        try {
            String line = "";
            final URL url = new URL("http://localhost:8084/company_z/webresources/nida.gov.api/findNidaData/" + nid);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(50000);
            connection.setReadTimeout(50000);
            final StringBuffer responseContent = new StringBuffer();
            final BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            if (connection.getResponseCode() > 299) {
                final BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = br.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                final BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = br.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            ret = parse(responseContent.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return ret;
    }

    public static void main(final String[] args) {
        NidaDataResponse res=validateNID("1234567890123457");
        if(res!=null){
          
            System.out.println("Data:"+res.getData().getFirstname());
        }else{
        
        }
        
    }

    public static NidaDataResponse parse(String jsonS){
        try{
        ObjectMapper mapper = new ObjectMapper();
        NidaDataResponse response = mapper.readValue(jsonS, NidaDataResponse.class);
        return response;
        }catch(Exception ex){
            return null;
        }
    }
}
