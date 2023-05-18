package com.coderpwh.member.domain.util;

import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtUtils {
    
    /**
     * 过期时间
     */
    public static long JWT_EXPIRE;

    @Value("${benefit.JWT_EXPIRE}")
    public void setJwtExpire(String JWT_EXPIRE) {
        JwtUtils.JWT_EXPIRE = Long.parseLong(JWT_EXPIRE);
    }

    /**
     * 根据id获取token
     *
     * @param userId
     * @param secret
     * @return
     */
    public static String getJwtToken(Long userId, String secret) {
        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "MD5")
                .setSubject("ll-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRE))
                .claim("userId", userId)
                .claim("timeStamp", System.currentTimeMillis())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return JwtToken;
    }


    /**
     * 获取用户token
     *
     * @return
     */
    public static String getToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String token = request.getHeader("token");
        return token;
    }


    /**
     * 根据token获取id
     */
    public static String getUserIdByJwtToken(String jwtToken, String secret) {
        if (StringUtils.isEmpty(jwtToken)) {
            return null;
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return String.valueOf(claims.get("userId"));
    }


    /***
     * 判断token是否过期
     * @param token
     * @param secret
     * @return
     */
    public static Boolean isTokenExpired(String token, String secret) {

        Claims claims = parseJwt(token, secret);

        Date expiration = claims.getExpiration();

        return new Date(System.currentTimeMillis()).after(expiration);
    }


    /***
     * 返回Claims 对象
     * @param token
     * @param secret
     * @return
     */
    public static Claims parseJwt(String token, String secret) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            claims = e.getClaims();
        }
        return claims;
    }

}
