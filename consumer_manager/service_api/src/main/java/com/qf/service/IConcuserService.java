package com.qf.service;

import com.qf.entity.Consumer;

public interface IConcuserService  {
    public int register(Consumer consumer);
    public int queryByNameAndPassword(String name,String password);
    public Consumer queryByName(String name);
}
