package com.aliexpress;

import com.aliexpress.model.Product;
import com.aliexpress.parser.JsonParser;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HttpClient {
    private final JsonParser jsonParser;

    public HttpClient() {
        jsonParser = new JsonParser();
    }

    public List<Product> readProducts(String requestUrl) throws IOException, JSONException {
        String response = getResponse(requestUrl);
        return jsonParser.getProducts(response);
    }


    private String getResponse(String requestUrl) throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();

        int status = connection.getResponseCode();
        InputStream in = (status != HttpURLConnection.HTTP_OK) ? connection.getErrorStream() : connection.getInputStream();
        return convertStreamToString(in);
    }

    private String convertStreamToString(InputStream stream) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        stream.close();

        return sb.toString();
    }

    public String getPostback() {
        return JsonParser.postbackJson;
    }
}
