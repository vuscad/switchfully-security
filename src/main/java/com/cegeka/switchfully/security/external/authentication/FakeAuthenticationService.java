package com.cegeka.switchfully.security.external.authentication;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class FakeAuthenticationService {

    private List<ExternalAuthenticaton> externalAuthenticatons = newArrayList(
            ExternalAuthenticaton.externalAuthenticaton().withUsername("ZWANETTA").withPassword("571bc95cbeac75db2c49d4ca070e2130").withRoles(newArrayList(new Role("CIVILIAN"))),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("JMILLER").withPassword("df89e795839ea42c0425275caa0e08fc").withRoles(newArrayList(new Role("PRIVATE"))),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("UNCLE").withPassword("9f1b3be4a82b11d104e4ef7f7ccb1c19").withRoles(newArrayList(new Role("HUMAN_RELATIONSHIPS"))),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("GENNY").withPassword("90628b8ee374d3e190ec8e056d660e10").withRoles(newArrayList(new Role("GENERAL")))
    );

    public ExternalAuthenticaton getUser(String username, String password) {
        return externalAuthenticatons.stream()
                .filter(externalAuthenticaton -> externalAuthenticaton.getUsername().equals(username))
                .filter(externalAuthenticaton -> externalAuthenticaton.getPassword().equals(DigestUtils.md5Hex(password)))
                .findFirst()
                .orElse(null);
    }
}