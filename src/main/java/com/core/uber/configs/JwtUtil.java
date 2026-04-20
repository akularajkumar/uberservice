package com.core.uber.configs;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final ServletContext servletContext;

    private String secretKey = "rajkumar@2310rajkumar@2310rajkumar@2310rajkumar@2310";

    private long expirationTime = 3600000; // 1 hour in milliseconds

    public JwtUtil(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String generateToken(Long riderId, String phoneNumber) {
        // Implement JWT token generation logic here

        SecretKey key  = Keys.hmacShaKeyFor(secretKey.getBytes());

        return Jwts.builder()
                .setSubject(String.valueOf(riderId))
                .claim("phoneNumber", phoneNumber)
                .setIssuedAt(new Date())
                .signWith(key , SignatureAlgorithm.HS256)
                .setExpiration(new java.util.Date(System.currentTimeMillis() + expirationTime))
                .compact();
    }
}
