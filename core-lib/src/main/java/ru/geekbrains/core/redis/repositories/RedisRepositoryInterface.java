package ru.geekbrains.core.redis.repositories;

import ru.geekbrains.core.redis.entity.Token;

import java.util.Map;

public interface RedisRepositoryInterface {
    Map<Object, Object> findAllToken();

    void add(Token token);

    void delete(String id);

    Token findToken(String id);
}
