package com.ipsen2.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

/**
 * This class facilitates the security of our application
 * through the use of JWT tokens
 *
 * @author Edward Deen
 */
public class JWTService {
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    byte[] secret = Base64.getDecoder().decode("QfOTMgpwGq5e2e7su2tLjURn1JQS5VFxWUzXOuodbGA");

    /**
     * This class builds a JWT token with the provided payload as a claim
     *
     * @author Edward Deen
     * @param payload
     * @return
     */
    public String buildJWT(Object payload){

        Instant now = Instant.now();
        Key signingKey = new SecretKeySpec(secret, signatureAlgorithm.getJcaName());

        String jwt = Jwts.builder()
                .claim("payload", payload)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(6 , ChronoUnit.HOURS)))
                .signWith(signingKey, signatureAlgorithm)
                .compact();

        return jwt;
    }

    /**
     * This class verifies if a given JWT token is valid
     *
     * @author Edward Deen
     * @param jwt
     * @return
     */
    public boolean verifyJWT(String jwt){
        boolean verification = false;

        try{
            Jws<Claims> result = Jwts.parser()
                    .setAllowedClockSkewSeconds(60)
                    .setSigningKey(Keys.hmacShaKeyFor(secret))
                    .parseClaimsJws(jwt);
            verification = true;
        } catch (io.jsonwebtoken.security.SignatureException se){
            System.out.println("JWT string signature is invalid");
        } catch (java.lang.IllegalArgumentException iae){
            System.out.println("JWT string is null");
        } catch (io.jsonwebtoken.MalformedJwtException mje) {
            System.out.println("JWT string is malformed");
        } catch (io.jsonwebtoken.ExpiredJwtException eje) {
            System.out.println("JWT string is expired");
        }

        return verification;
    }
}
