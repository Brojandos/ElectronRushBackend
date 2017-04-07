package com.brojandos.web.electronrush.model;

import com.brojandos.web.electronrush.common.Constants;

/**
 * @author: Brojandos
 * @creation_date: Mar 18, 2017
 */
public class LoginBean {
    private String name;
    private String password;
    
    public LoginBean(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean validate() {
        return password.equals(Constants.GLOBAL_PASSWORD);
    }
}
