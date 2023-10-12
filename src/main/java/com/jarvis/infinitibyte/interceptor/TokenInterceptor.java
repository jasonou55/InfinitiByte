package com.jarvis.infinitibyte.interceptor;

import com.jarvis.infinitibyte.utilities.TokenUtility;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String bearToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.startsWithIgnoreCase(bearToken, BEARER_PREFIX)) {
            String token = bearToken.substring(7);
            return TokenUtility.verify(token);
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }
}
