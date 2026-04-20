package com.core.uber.services;

import com.core.uber.configs.JwtUtil;
import com.core.uber.dtos.riderDto;
import com.core.uber.models.Rider;
import com.core.uber.repositories.RiderRepository;
import com.core.uber.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class UserService {

    @Autowired
    RiderRepository riderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    public  String signUp(riderDto riderDto){

        Rider rider = new Rider();
        rider.setPhoneNumber(riderDto.getPhoneNumber());


        riderRepository.save(rider);

        return "successfully signed up";

    }

    public void otpRequest(String  phoneNumber) {
        // generate otp
        // send otp to phone number

       String otp =  String.valueOf(new SecureRandom().nextInt(900000) + 100000);

       redisTemplate.opsForValue().set(phoneNumber, otp);

        System.out.println("OTP for " + phoneNumber + ": " + otp);

    }

    public String validateOtp(String phoneNumber, String otp){
       String otpverified = redisTemplate.opsForValue().get(phoneNumber).toString();
      if(otpverified.equals(otp)){

        Rider rider=  riderRepository.findByPhoneNumber(phoneNumber);
              if(rider!=null){


              }
              else{
                     Rider rider1  = new Rider();
                     rider1.setPhoneNumber(phoneNumber);
                     riderRepository.save(rider1);
              }
          Rider riderDetail =  riderRepository.findByPhoneNumber(phoneNumber);
          String token  = jwtUtil.generateToken(riderDetail.getId(),phoneNumber);
          redisTemplate.opsForValue().set("token:"+phoneNumber, token);
          return token;


      }
      return "Wrong otp";
    }
}
