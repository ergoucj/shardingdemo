package com.example.sharding.shardingdemo.service;

import com.example.sharding.shardingdemo.config.ShardingMasterConnection;
import com.example.sharding.shardingdemo.dao.BookMapper;
import com.example.sharding.shardingdemo.entity.Book;
import com.example.sharding.shardingdemo.entity.BookExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private BookMapper bookMapper;

    @ShardingMasterConnection
    public List<Book> getAll() {
        BookExample example = new BookExample();
        BookExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(1);
        return bookMapper.selectByExample(example);
    }

    public List<Book> get() {
        BookExample example = new BookExample();
        return bookMapper.selectByExample(example);
    }
}
