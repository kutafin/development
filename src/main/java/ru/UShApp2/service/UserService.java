package ru.springapp.service;

import ru.springapp.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
