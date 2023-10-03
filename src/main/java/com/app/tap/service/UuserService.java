package com.app.tap.service;

import com.app.tap.entitites.Uuser;
import com.app.tap.repository.UuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UuserService {

    @Autowired
    UuserRepository uuserRepository;
    public void newUser(Uuser uuser){
        uuserRepository.save(uuser);
    }

}
