package com.zosh.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.util.*;

@Configuration

public class JwtProvider {

   private static final SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

   public static String generateToken(Authentication auth){
       Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
       String roles = populateAuthorities(authorities);

       String jwt = Jwts.builder().setIssuedAt(new Date())
               .setExpiration((new Date(new Date().getTime()+86400000)))
               .claim("email",auth.getName())
               .claim("authorities",roles)
               .signWith(key)
               .compact();


       return  jwt;
   }

   public String getEmailFromJwtToken(String jwt){
       jwt = jwt.substring(7);

       Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();

       String email= String.valueOf(claims.get("email"));

       return email;
   }

    private static String populateAuthorities(Collection<? extends GrantedAuthority> authorities) {

        Set<String> auths= new HashSet<>();

        for (GrantedAuthority authority:authorities){
            auths.add(authority.getAuthority());
        }
        return String.join(",",auths);
    }
}
