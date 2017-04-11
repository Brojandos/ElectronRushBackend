package com.brojandos.web.electronrush.entity;

/**
 * @author: Brojandos
 * @creation_date: Mar 16, 2017
 */
public class User extends BaseEntity {
    private String password;
    private int record;
    
    public User() {}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }
}
