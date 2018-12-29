package com.binglian.pojo;

import javax.persistence.*;

public class User {
    @Id
    private Integer id;

    private String username;

    private String password;

    private String rolse;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return rolse
     */
    public String getRolse() {
        return rolse;
    }

    /**
     * @param rolse
     */
    public void setRolse(String rolse) {
        this.rolse = rolse;
    }
}