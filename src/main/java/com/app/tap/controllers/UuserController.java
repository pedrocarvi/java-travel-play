package com.app.tap.controllers;

import com.app.tap.entitites.Uuser;
import com.app.tap.service.UuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UuserController {

    @Autowired
    UuserService uuserService;
    @PostMapping("/create")
    public void create(@RequestBody Uuser uuser){
        uuserService.newUser(uuser);
    }

}

