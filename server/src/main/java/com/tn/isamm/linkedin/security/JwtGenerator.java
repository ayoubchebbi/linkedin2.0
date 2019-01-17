package com.tn.isamm.linkedin.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import com.tn.isamm.linkedin.entity.Utilisateur;

@Component
public class JwtGenerator {


    public String generate(Utilisateur jwtUser) {

        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getEmail());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        //claims.put("role", jwtUser.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "Efive")
                .compact();
    }
}
