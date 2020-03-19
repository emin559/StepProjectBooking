package app.controller;

import app.entities.User;
import app.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserController {
    UserService userService= new UserService();


    public List<User> getAll() {
        return userService.getAll();
    }

    public User getByID(int ID) {
        return userService.getByID(ID).get();
    }

    public boolean delete(int ID) {
        return userService.delete(ID);
    }

    public boolean save() {
        return userService.save();
    }

    public void register(String username, String pass) {
        userService.register(username, pass);
    }

    public void fillList() {
        userService.fillList();
    }
}
