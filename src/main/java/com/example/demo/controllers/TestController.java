package com.example.demo.controllers;

import com.example.demo.dto.TestPerson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = {"application/json"})
    public String test() {
        return "Hello";
    }
@RequestMapping(value = "/person", method = RequestMethod.POST, produces = {"application/json"})
public TestPerson testpost(@RequestBody TestPerson testPerson){
        testPerson.setFirstname(testPerson.getFirstname() + "from server");
return testPerson;

    }


}
