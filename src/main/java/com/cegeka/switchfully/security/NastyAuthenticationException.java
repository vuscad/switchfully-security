package com.cegeka.switchfully.security;

import org.springframework.security.core.AuthenticationException;

public class NastyAuthenticationException extends AuthenticationException {

    public NastyAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public NastyAuthenticationException(String msg) {
        super(msg);
    }
}
