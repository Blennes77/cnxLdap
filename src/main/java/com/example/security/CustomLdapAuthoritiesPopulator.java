package com.example.security;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by garnons on 30/11/2016.
 */
@Component
public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {
    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations ctx, String username) {
        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        if(username.equals("garnons")) {
            authorities.add(new SimpleGrantedAuthority("admin"));
        } else
        {
            authorities.add(new SimpleGrantedAuthority("user"));
        }
        return authorities;
    }
}
