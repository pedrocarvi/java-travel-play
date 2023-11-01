package com.app.tap.service;

import com.app.tap.entitites.Posted;
import com.app.tap.repository.PostedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostedService {

     @Autowired
     PostedRepository _postedRepository;

     public Posted newPosted(Posted _posted){
          return _postedRepository.save(_posted);
     }




}
