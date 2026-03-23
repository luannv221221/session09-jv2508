package com.ra.security.jwt;

import com.ra.security.UserPrinciple;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    @Value("${jwt_secret_key}")
    private String jwtSecretKey;
    @Value("${jwt_expired}")
    private int jwtExpired;

    private Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    // tao ra token
    public String generateToken(UserPrinciple userPrinciple) {
        Date deteExpiration = new Date(new Date().getTime() + jwtExpired * 1000);
        return Jwts.builder().setSubject(userPrinciple.getUsername()).signWith(SignatureAlgorithm.HS256,jwtSecretKey)
                .setExpiration(deteExpiration)
                .compact();
    }

    // phuong thuc validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    // phuong thuc lay ve thong tin cua userName dựa vào token gửi lên từ client
    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token).getBody().getSubject();
    }
}
