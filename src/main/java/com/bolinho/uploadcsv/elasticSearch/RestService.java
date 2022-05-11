package com.bolinho.uploadcsv.elasticSearch;

import java.io.IOException;

import com.bolinho.uploadcsv.models.Produto;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class RestService {
    public static void post(Produto p) throws IOException {
        
        String jsonFile = new Gson().toJson(p);

        HttpEntity entity = new StringEntity(jsonFile);
        HttpPost post = new HttpPost("http://localhost:9200/produtos/_doc");
        post.setEntity(entity);
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = clientBuilder.build();
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Accept", "text/plain");
        var response = client.execute(post);
        System.out.println("Response: " + response);
    }

    public static void deleteAll() throws IOException {
        
        HttpDelete delete = new HttpDelete("http://localhost:9200/produtos/");
        
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = clientBuilder.build();
        // post.addHeader("Content-Type", "application/json");
        // post.addHeader("Accept", "text/plain");
        var response = client.execute(delete);
        System.out.println("Response: " + response);
    }
}
