package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by garnons on 18/11/2016.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/webjars/**", "/css/**", "/images/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll().and()
                .logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      /*  auth.ldapAuthentication()
                .userDnPatterns("cn={0},ou=People")
                .groupSearchBase("ou=groupes")
                .contextSource().url("ldap://127.0.0.1:389/dc=maxcrc,dc=com");
                */
    /*  Fonctionne sur mon LDAP */
    /*auth.ldapAuthentication()
        .userSearchFilter("cn={0}")
        .groupSearchBase("ou=groupes")
        .contextSource().url("ldap://127.0.0.1:389/dc=maxcrc,dc=com");*/

    /* Fonctionne sur AD Groupinfra */
        auth.ldapAuthentication()
                .userSearchFilter("cn={0}")
                .groupSearchFilter("member={0}")
                .contextSource().url("ldap://10.83.3.30:3268/dc=groupinfra,dc=com")
                .managerDn("CN=SA-FR-LDAP_Query,OU=Service Accounts,OU=FR,OU=Landlord FR,OU=Corporate,DC=groupinfra,DC=com")
                .managerPassword("ywxZFHoyTEsL1");
    }
}
