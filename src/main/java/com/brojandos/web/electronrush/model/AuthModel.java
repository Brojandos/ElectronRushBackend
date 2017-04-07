package com.brojandos.web.electronrush.model;

import com.brojandos.web.electronrush.entity.User;

/**
 * @author: Brojandos
 * @creation_date: Mar 16, 2017
 */
public class AuthModel {
    private User user;

    public AuthModel(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
