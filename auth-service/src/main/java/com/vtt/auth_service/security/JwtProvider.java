package com.vtt.auth_service.security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {
    private static final String SECRET =
            "my-super-secret-key-my-super-secret-key";

    private static final long EXPIRATION = 60 * 60 * 1000; // 1h

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    /* co nhieu cach ky JWT
    *  HMAC(HS256, HS384, HS512)
    *  RSA(RS256, RS384, RS512)
    *  ECDSA(ES256, ES384, ES512)
    * */

    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
