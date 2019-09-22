package com.example.demomybatis.controller;

import com.example.demomybatis.repository.SampleRepository;
import com.example.demomybatis.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoMybatisController {

    @Autowired
    TestRepository testRepository;

    @Autowired
    SampleRepository sampleRepository;

    @GetMapping("/test/{id}")
    public String test(@PathVariable long id){
        return "test find : " + testRepository.getTest(id);
    }

    @GetMapping("/test/count")
    public String testCount(){
        return "test total : " + testRepository.getTotal();
    }

    @GetMapping("/test/caller")
    public String testCaller(){
        return "test total : " + testRepository.getTest2();
    }

    @GetMapping("/test")
    public String testName(@RequestParam String name){
        testRepository.insertName(name);
        return name;
    }

    @GetMapping("/sample/{id}")
    public String sample(@PathVariable long id){
        return "test find : " + sampleRepository.getTest(id);
    }

    @GetMapping("/sample/count")
    public String sampleCount(){
        return "test total : " + sampleRepository.getTotal();
    }

    @GetMapping("/sample/caller")
    public String sampleCaller(){
        return "test total : " + sampleRepository.getTest2();
    }

    @GetMapping("/sample")
    public String sampleName(@RequestParam String name){
        sampleRepository.insertName(name);
        return name;
    }
}
