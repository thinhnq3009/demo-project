package com.intern.demoproject.service;

import com.intern.demoproject.entity.User;
import com.intern.demoproject.utils.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.intern.demoproject.utils.Constants.Jwt.SECRET_KEY;
import static com.intern.demoproject.utils.Constants.Jwt.TIME_LIFE;

@Service
public class JwtService {

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(User user) {

        Map<String, String> claims = new HashMap<>();

        claims.put("id", user.getId().toString());
        claims.put("fullname", user.getFullname());
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole().name());

        return generateToken(user.getUsername(), claims);
    }


    public String generateToken(String username, Map<String, ?> claims) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(username)
                .setExpiration(new java.util.Date(System.currentTimeMillis() + TIME_LIFE))
                .setIssuedAt(new java.util.Date())
                .signWith(getSignInKey())
                .compact();
    }

    private Key getSignInKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }


    public User extractUser(String token) {
        Claims claims = extractAllClaims(token);

        User user = new User();
        try {
            user.setId(Long.parseLong(claims.get("id").toString()));
            user.setFullname(claims.get("fullname").toString());
            user.setEmail(claims.get("email").toString());
            user.setRole(Role.valueOf(claims.get("role").toString()));
            user.setUsername(claims.getSubject());
        } catch (Exception e) {
            return null;
        }
        return user;

    }

    public boolean isExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new java.util.Date());
    }

    public boolean isValid(String token) {
        return !isExpired(token);
    }
}
