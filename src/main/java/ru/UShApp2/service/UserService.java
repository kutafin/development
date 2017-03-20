package ru.UShApp2.service;

import ru.UShApp2.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
