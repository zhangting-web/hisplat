package com.mh.hisplat.exception;

import org.apache.shiro.authc.AuthenticationException;

public class LoginException extends AuthenticationException {

    public LoginException(String s, AuthenticationException e) {
        super(s,e);
    }
}
