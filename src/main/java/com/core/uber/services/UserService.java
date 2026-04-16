package com.core.uber.services;

import com.core.uber.dtos.riderDto;
import com.core.uber.models.Rider;
import com.core.uber.repositories.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    RiderRepository riderRepository;


    public  String signUp(riderDto riderDto){

        Rider rider = new Rider();
        rider.setName(riderDto.getName());
        rider.setName(rider.getName());
        rider.setUserName(riderDto.getEmail());

        rider.setPassword(riderDto.getPassword());

        riderRepository.save(rider);

        return "successfully signed up";

    }

    public void otpRequest(Object otpRequest) {

    }
}
