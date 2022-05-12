package com.bolinho.uploadcsv.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.bolinho.uploadcsv.models.Cliente;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

// @Component
public class RedisService {

    // @Autowired
    // private IClienteService service;

    private Jedis jedis;

    public RedisService() {
        this.jedis = new Jedis("http://localhost:6379");
    }

    public List<Cliente> convertList(List<String> lista) {
        List<Cliente> clientes = new ArrayList<Cliente>();
        for (String s : lista) {
            clientes.add(new Gson().fromJson(s, new Cliente().getClass()));
        }
        return clientes;
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

    public void setDataInRedis(List<Cliente> clientes) {
        this.writeArray("clientes", clientes);
    }

    // public List<?> searchRedis() {
    // // busca no redis
    // Set<String> clientesRedis = this.read();
    // if (clientesRedis.isEmpty()) {
    // return this.setDataInRedis();
    // }
    // List<String> lista = List.copyOf(clientesRedis);
    // return lista;
    // }

}
