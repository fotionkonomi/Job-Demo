package de.dh.lhind.demo.jobapi.security.util;

import de.dh.lhind.demo.jobapi.security.constant.JWTClaims;
import de.dh.lhind.demo.jobapi.security.exception.MyAuthenticationException;
import de.dh.lhind.demo.jobapi.security.userdetails.MyUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {
    @Value("${security.jwt.secretkey}")
    private String jwtSecretKey;

    @Value("${security.jwt.time.valid}")
    private Long tokenTimeValid;

    private Claims extractAlClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(MyUserDetails myUserDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(JWTClaims.ID_CLAIM, myUserDetails.getId());
        claims.put(JWTClaims.FIRSTNAME_CLAIM, myUserDetails.getFirstName());
        claims.put(JWTClaims.LASTNAME_CLAIM, myUserDetails.getLastName());
        claims.put(JWTClaims.EMAIL_CLAIM, myUserDetails.getEmail());
        claims.put(JWTClaims.ROLE_CLAIM, myUserDetails.getRole());
        return createToken(claims, myUserDetails.getUsername());
    }


    private String createToken(Map<String, Object> claims, String subject) {
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder().setClaims(claims).setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(currentTimeMillis))
                .signWith(SignatureAlgorithm.HS256, jwtSecretKey)
                .compact();
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAlClaims(token);
        return claimsResolver.apply(claims);
    }

    public MyUserDetails extractUserFromToken(String token) {
        if (this.isTokenExpired(token)) {
            throw new MyAuthenticationException("Token is invalid!");
        }
        Claims claims = this.extractAlClaims(token);
        Long id = claims.get(JWTClaims.ID_CLAIM, Long.class);
        String firstName = claims.get(JWTClaims.FIRSTNAME_CLAIM, String.class);
        String lastName = claims.get(JWTClaims.LASTNAME_CLAIM, String.class);
        String email = claims.get(JWTClaims.EMAIL_CLAIM, String.class);
        String role = claims.get(JWTClaims.ROLE_CLAIM, String.class);
        return MyUserDetails.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .role(role)
                .build();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        return extractUserFromToken(token).equals(userDetails) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date(System.currentTimeMillis()));
    }

}
