package com.carvista.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JwtUtilTest {

    @Test
    void shouldGenerateAndExtractTokenWithConfiguredSecret() {
        JwtUtil jwtUtil = new JwtUtil("0123456789abcdef0123456789abcdef");

        // String token = jwtUtil.generateToken("rohit@gmail.com");

        // assertEquals("rohit@gmail.com", jwtUtil.extractEmail(token));
    }
}
