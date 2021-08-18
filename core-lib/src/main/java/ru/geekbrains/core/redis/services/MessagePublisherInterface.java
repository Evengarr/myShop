package ru.geekbrains.core.redis.services;

public interface MessagePublisherInterface {
    void publish(final String message);
}
