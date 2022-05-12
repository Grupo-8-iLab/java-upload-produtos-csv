package com.bolinho.uploadcsv.services;

import java.util.List;
import java.util.Set;

import com.bolinho.uploadcsv.models.Cliente;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

@Service
public class RedisService {
    private Jedis jedis;

    @Autowired
    private IClienteService service;

    public RedisService() {
        this.jedis = new Jedis("http://localhost:6379");
    }

    public void writeString(String key, String value, long expireInSeconds) {
        SetParams params = new SetParams();
        params.ex(expireInSeconds);
        jedis.set(key, value, params);
    }

    public void writeArray(String key, List<Cliente> list) {
        for (Cliente c : list) {
            String jsonFile = new Gson().toJson(c);
            jedis.sadd(key, jsonFile);
            jedis.expire(key, 30);
        }
    }

    public Set<String> read() {
        Set<String> clientes = jedis.smembers("clientes");
        return clientes;
    }

    public List<Cliente> setDataInRedis() {
        List<Cliente> clientes = service.getAll();
        System.out.println(clientes);
        // this.writeArray("clientes", clientes);
        return null;
    }

    public List<?> searchRedis() {
        // busca no redis
        Set<String> clientesRedis = this.read();
        if (clientesRedis.isEmpty()) {
            return this.setDataInRedis();
        }
        List<String> lista = List.copyOf(clientesRedis);
        return lista;
    }

}
