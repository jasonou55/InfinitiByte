package com.jarvis.infinitibyte.controller;

import com.jarvis.infinitibyte.manager.TokenManager;
import com.jarvis.infinitibyte.request.GenerateTokenRequest;
import com.jarvis.infinitibyte.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/oauth")
public class TokenController {

    @Autowired
    private TokenManager tokenManager;

    @PostMapping(value="/token")
    @ResponseBody
    public TokenResponse generateToken(@RequestBody GenerateTokenRequest generateTokenRequest) {
        return tokenManager.generateToken(generateTokenRequest.getIdentityId(), generateTokenRequest.isLongTerm());
    }
}
