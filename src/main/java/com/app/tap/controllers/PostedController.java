package com.app.tap.controllers;


import com.app.tap.entitites.Posted;
import com.app.tap.exceptions.BadRequestException;
import com.app.tap.exceptions.ResourceNotFoundException;
import com.app.tap.service.PostedService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posted")
public class PostedController {

        @Autowired
        PostedService _postedService;

        @PostMapping("/create")
        public ResponseEntity<Posted> newPosted(@RequestBody Posted new_posted) throws BadRequestException {

                _postedService.newPosted(new_posted);           //Guardo el posteo

                return ResponseEntity.ok(new_posted);   //Retorno ok en la response.

        }

        @GetMapping("/getAll")
        public ResponseEntity<List> getAllPosted() throws ResourceNotFoundException {

                        List<Posted> postedList = _postedService.getAll();       //Guardo la lista de posteos en una varieble.


                        return  ResponseEntity.ok(postedList); //Retorno la lista de posteos
        }



}
