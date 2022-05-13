package com.bolinho.uploadcsv.elasticSearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bolinho.uploadcsv.models.ElasticRequestList;
import com.bolinho.uploadcsv.models.Produto;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class RestService {
    public static void post(Produto p) throws IOException {

        String jsonFile = new Gson().toJson(p);

        HttpEntity entity = new StringEntity(jsonFile);
        // HttpPost post = new HttpPost("http://localhost:9200/produtos/_doc");
        HttpPost post = new HttpPost(System.getenv("URL_ELASTIC") + "_doc");
        post.setEntity(entity);
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = clientBuilder.build();
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Accept", "text/plain");
        var response = client.execute(post);
        System.out.println("Response: " + response);
    }

    public static void deleteAll() throws IOException {

        // HttpDelete delete = new HttpDelete("http://localhost:9200/produtos/");
        HttpDelete delete = new HttpDelete(System.getenv("URL_ELASTIC"));
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = clientBuilder.build();
        // post.addHeader("Content-Type", "application/json");
        // post.addHeader("Accept", "text/plain");
        var response = client.execute(delete);
        System.out.println("Response Delete : " + response);
    }

    public static List<Produto> search(String searchString) throws IOException {
        // HttpGet get = new HttpGet("http://localhost:9200/produtos/_search?q=" +
        // searchString);
        HttpGet get = new HttpGet(System.getenv("URL_ELASTIC") + "_search?q=" + searchString);
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = clientBuilder.build();
        get.addHeader("Content-Type", "application/json");
        get.addHeader("Accept", "text/plain");
        var response = client.execute(get);

        String responseAsString = EntityUtils.toString(response.getEntity());

        var elasticRequestList = new Gson().fromJson(responseAsString, ElasticRequestList.class);

        List<Produto> products = new ArrayList<>();

        var hits = (List<LinkedTreeMap>) ((LinkedTreeMap) elasticRequestList.get_hits()).get("hits");

        for (var productUnmapped : hits) {
            var product_json = new Gson().toJson(productUnmapped.get("_source"));
            var product = new Gson().fromJson(product_json, Produto.class);
            products.add(product);
        }

        return products;
    }

    public static List<Produto> getList() throws IOException {
        // HttpGet get = new HttpGet("http://localhost:9200/produtos/_search");
        HttpGet get = new HttpGet(System.getenv("URL_ELASTIC") + "_search");
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = clientBuilder.build();
        get.addHeader("Content-Type", "application/json");
        get.addHeader("Accept", "text/plain");
        var response = client.execute(get);

        String responseAsString = EntityUtils.toString(response.getEntity());

        ElasticRequestList elasticRequestList = new Gson().fromJson(responseAsString, ElasticRequestList.class);

        List<Produto> products = new ArrayList<>();

        var hits = (List<LinkedTreeMap>) ((LinkedTreeMap) elasticRequestList.get_hits()).get("hits");

        for (var productUnmapped : hits) {
            var product_json = new Gson().toJson(productUnmapped.get("_source"));
            var product = new Gson().fromJson(product_json, Produto.class);
            products.add(product);
        }

        return products;
    }
}
