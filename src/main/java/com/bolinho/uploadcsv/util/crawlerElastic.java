package com.bolinho.uploadcsv.util;

import java.io.IOException;
import java.util.List;

import com.bolinho.uploadcsv.dao.ProdutoDAO;
import com.bolinho.uploadcsv.elasticSearch.RestService;
import com.bolinho.uploadcsv.models.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class crawlerElastic {

    @Autowired
    private ProdutoDAO dao;

    @Scheduled(fixedDelay = 20 * TimeUnits.MINUTOS)
    public void populandoProdutos() throws IOException {

        RestService.deleteAll();

        List<Produto> produtos = (List<Produto>) dao.findAll();
        produtos.forEach(iten -> {
            try {
                RestService.post(iten);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
