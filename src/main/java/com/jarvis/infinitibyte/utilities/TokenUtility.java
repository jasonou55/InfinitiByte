package com.jarvis.infinitibyte.utilities;

import com.jarvis.infinitibyte.response.TokenResponse;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenUtility {
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenUtility.class);
    private static final long EXPIRE_TIME= 10*60*60*1000;
    private static final String TOKEN_SECRET="InfinitiByte";  //密钥盐

    /**
     * Generate token
     * @param identityId the identity id which need to generate a token
     * @return boolean
     */
    public static TokenResponse sign(String identityId, boolean isLongTerm){
        Date expiresAt;
        try {
            if (isLongTerm) {
                expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME * 100);
            } else {
                expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            }

            String token = Jwts.builder()
                                .setSubject(identityId)
                                .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET)
                                .setExpiration(expiresAt)
                                .compact();

            return new TokenResponse(token, expiresAt.toString());
        } catch (Exception e){
            LOGGER.warn("Generate token failed. {}", e.getMessage());
            throw e;
        }
    }

    /**
     * Verify token
     * @param token the token waiting for verify
     * @return boolean
     */
    public static boolean verify(String token){
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(TOKEN_SECRET)
                    .parseClaimsJws(token);
            Claims body = claims.getBody();
            return body.getExpiration().after(new Date());
        } catch (SignatureException e) {
            LOGGER.info("Verify token failed: {}", e.getMessage());
            return false;
        }
    }
}
