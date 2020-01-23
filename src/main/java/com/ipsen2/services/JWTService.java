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

public class JWTService {

    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    byte[] secret = Base64.getDecoder().decode("QfOTMgpwGq5e2e7su2tLjURn1JQS5VFxWUzXOuodbGA");

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

    public boolean verifyJWT(String jwt){
        boolean verification;

        try{
            Jws<Claims> result = Jwts.parser()
                    .setAllowedClockSkewSeconds(60)
                    .setSigningKey(Keys.hmacShaKeyFor(secret))
                    .parseClaimsJws(jwt);
            verification = true;
        } catch (io.jsonwebtoken.security.SignatureException se){
            verification = false;
            se.printStackTrace();
            System.out.println("JWT string signature is invalid");
        } catch (java.lang.IllegalArgumentException iae){
            verification = false;
            System.out.println("JWT string is null");
        } catch (io.jsonwebtoken.MalformedJwtException mje) {
            System.out.println("JWT string is malformed");
            System.out.println();
            verification = false;
        }

        return verification;
    }
}
