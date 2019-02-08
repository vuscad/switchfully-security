package com.cegeka.switchfully.security;

import com.cegeka.switchfully.security.external.authentication.ExternalAuthenticaton;
import com.cegeka.switchfully.security.external.authentication.FakeAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service("properAuth")
public class AuthenticationProviderImpl implements AuthenticationProvider {

    @Autowired
    private FakeAuthenticationService fakeAuthenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ExternalAuthenticaton authData = fakeAuthenticationService.getUser(authentication.getName(), (String) authentication.getCredentials());

        if (authData == null) {
            throw new NastyAuthenticationException("Damn son");
        }

        return new UsernamePasswordAuthenticationToken(authData.getUsername(), authData.getPassword(), authData.getRoles());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return  aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
