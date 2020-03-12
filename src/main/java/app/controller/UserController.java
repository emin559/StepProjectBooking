package app.controller;

import app.entities.User;
import app.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserController {
    UserService userService;

    public void create() {
        userService.create();
    }

    public List<User> getAll() {
        return userService.getAll();
    }

    public Optional<User> getByID(int ID) {
        return userService.getByID(ID);
    }

    public boolean delete(int ID) {
        return userService.delete(ID);
    }

    public boolean save(User entity) {
        return userService.save(entity);
    }

    public boolean update(User entity) {
        return userService.update(entity);
    }

    public void register(String username, String pass) {
        userService.register(username, pass);
    }

    public static void main(String[] args) {
        UserService sr = new UserService();
        sr.register("Emin", "12345");
    }
}
