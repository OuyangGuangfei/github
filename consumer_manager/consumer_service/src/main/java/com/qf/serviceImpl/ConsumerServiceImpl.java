package com.qf.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.ConsumerMapper;
import com.qf.entity.Consumer;
import com.qf.service.IConcuserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Wrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConsumerServiceImpl implements IConcuserService {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Override
    public int register(Consumer consumer) {
        return consumerMapper.insert(consumer);
    }

    @Override
    public int queryByNameAndPassword(String name, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("password",password);
        List<Consumer> consumers =  consumerMapper.selectByMap(map);
        return consumers.size();
    }

    @Override
    public Consumer queryByName(String name) {

        return null;
    }
}
