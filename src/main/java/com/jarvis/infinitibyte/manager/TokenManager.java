package com.jarvis.infinitibyte.manager;

import com.jarvis.infinitibyte.response.TokenResponse;
import com.jarvis.infinitibyte.utilities.TokenUtility;
import org.springframework.stereotype.Service;

@Service
public class TokenManager {

    public TokenResponse generateToken(final String identityId, final boolean isLongTerm) {
        return TokenUtility.sign(identityId, isLongTerm);
    }
}
