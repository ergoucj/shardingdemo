package com.example.sharding.shardingdemo.web;

import com.example.sharding.shardingdemo.entity.Book;
import com.example.sharding.shardingdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/get")
    public List<Book> get(){
        return testService.get();
    }

    @RequestMapping("/getAll")
    public List<Book> getAll(){
        return testService.getAll();
    }
}
