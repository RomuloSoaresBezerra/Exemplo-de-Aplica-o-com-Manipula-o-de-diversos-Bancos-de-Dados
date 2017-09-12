
package com.ifpb.ecommerce_exempBDs.DAO;

import com.google.gson.Gson;
import com.ifpb.ecommerce_exempBDs.entidades.Carrinho;
import redis.clients.jedis.Jedis;

public class DAORedis {
    
    private Gson gson;
    private Jedis jedis;
    

    public DAORedis() {
        gson = new Gson();
        jedis = new Jedis("127.0.0.1", 6379);
       
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public Jedis getJedis() {
        return jedis;
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }
    
    public void addRegistro(Carrinho car){
        
        String json = getGson().toJson(car);
        getJedis().setex(String.valueOf(car.getId()), 7200, json);  
        
    }
    
    public Carrinho readRegistro(String id){
        Carrinho carRedis = gson.fromJson(jedis.get(id), Carrinho.class);
        
        return carRedis;
    }
    
    public void deletRegistro(Carrinho car){
        getJedis().del(getGson().toJson(car.getId()));
    }

    
}
