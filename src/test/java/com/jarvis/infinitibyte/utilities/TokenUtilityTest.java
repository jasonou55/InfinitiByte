package com.jarvis.infinitibyte.utilities;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

public class TokenUtilityTest {

    @Test
    public void tokenTest() {
        String prefix = "Bearer ";
        String testToken = "Bearer qwe!@#$234";
        assert StringUtils.startsWithIgnoreCase(testToken, prefix);
        assert testToken.substring(7).equalsIgnoreCase("qwe!@#$234");
    }
}
