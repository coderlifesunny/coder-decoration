package com.decoration.web.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Description: JWTToken
 *
 * @Author Guangcai.xu
 * @Date 2018/11/17 11:36
 */
public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
