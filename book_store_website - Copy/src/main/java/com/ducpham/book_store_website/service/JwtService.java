package com.ducpham.book_store_website.service;

import com.ducpham.book_store_website.entity.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET = "9a2f8c4e6b0d71f3e8b925a45747f894a3d6bc70fa8d5e21a15a6d8c3b9a0e7c";

    public String generateToken(Account user) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .claims(claims)
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }



    //Extracts all claims from the JWT token.
    //return-> Claims object containing all claims.
    public Claims extractAllClaims(String token) {
        // Parse and return all claims from the token
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    //    Extracts a specific claim for the jwt
    public  <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

//    Extract username
    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

//    Extract expiration
    public Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

//    Check if the jwt is expired
    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

//    validate jwt
    public Boolean validateToken(String token, UserDetails userDetails, Authentication authentication) {
//        extract username from token and check if it matches UserDetails's name
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }







}
