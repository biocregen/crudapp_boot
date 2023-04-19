package ru.crudboot.myCrudAppBoot.service;


import ru.crudboot.myCrudAppBoot.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    List<User> getAllUser();

    User getById(int id);
}
