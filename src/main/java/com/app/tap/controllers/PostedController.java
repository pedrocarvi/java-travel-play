package com.app.tap.controllers;


import com.app.tap.entitites.Posted;
import com.app.tap.service.PostedService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posted")
public class PostedController {

        @Autowired
        PostedService _postedService;

        //@PostMapping("/create")
        //public ResponseEntity<Posted> newPosted(@RequestBody Posted new_posted){


        //}


}
