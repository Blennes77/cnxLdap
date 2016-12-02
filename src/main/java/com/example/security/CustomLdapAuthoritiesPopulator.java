package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by garnons on 30/11/2016.
 */

@Service("myCustomLdapAuthorities")
public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations ctx, String username) {
        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        //TODO
        // Un user à toujours le ROLE_USER
        // On check en base dans la table XXXX si le user existe dans les données PSA, si oui on ajoute le ROLE_DP
        // On check en base dans la table YYYY si le user a le flag Admin, si oui on ajoute le ROLE_ADMIN

        if(username.contains("garnon")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else
        {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorities;
    }
}
