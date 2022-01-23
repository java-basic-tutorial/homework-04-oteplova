package com.softserveinc.task03;

import java.util.HashSet;
import java.util.Set;

import com.softserveinc.task03.User;

public class UserManager {
    private final Set<User> users;

    public UserManager() {
        this.users = new HashSet<User>();
    }

    public void register(String login, String password) {
        User newUser = new User(login, password);
        this.users.add(newUser);
    }

    public void delete(String login) {
        for (User user : this.users) {
            if (user.getLogin().equals(login)) {
                this.users.remove(user);
                break;
            }
        }
    }

    public boolean exists(String login, String password) {
        for (User user : this.users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean changePassword(String login, String oldPassword, String newPassword){
        for (User user : this.users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(oldPassword)) {
                user.setPassword(newPassword);
                return true;
            }
        }
        return false;
    }

}
