package ru.geekbrains.core.redis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import ru.geekbrains.core.redis.entity.Token;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class RedisRepository implements RedisRepositoryInterface{
    private static final String KEY = "Token";
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public RedisRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    public void add(final Token token) {
        hashOperations.put(KEY, token.getId(), token.getValuesToken());
    }

    public void delete(final String id) {
        hashOperations.delete(KEY, id);
    }

    public Token findToken(final  String id) {
        return (Token) hashOperations.get(KEY, id);
    }

    public Map<Object, Object> findAllToken() {
        return hashOperations.entries(KEY);
    }

    //JedisConnectionFactory

    public boolean checkToken(String authorizationHeader) {
        //через CRUD(findAllToken) проганв мапу, проверить наличие токена в redis
        return true;
    }

    public void saveToken(String token) {
        //через CRUD(add) сохранить token в redis
    }


}
