package com.qf.entity;

public class Consumer {

    private String name;
    private String password;
    private String nickname;
    private String email;

    public Consumer(String name, String password, String nickname, String email) {
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    public Consumer() {

    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
