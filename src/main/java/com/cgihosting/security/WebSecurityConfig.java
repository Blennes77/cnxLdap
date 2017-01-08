package com.cgihosting.security;

import com.cgihosting.domain.ParametresAppliDTO;
import com.cgihosting.service.admin.ParametrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

import java.util.Collection;

/**
 * Created by garnons on 18/11/2016.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private Environment env;
    @Autowired
    @Qualifier("myCustomLdapAuthorities")
    LdapAuthoritiesPopulator myCustomLdapAuthorities;


    @Autowired
    private ParametrerService parametrerService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/webjars/**", "/css/**", "/images/**").permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll().and()
                .logout().permitAll();
    }

    @Bean
    public UserDetailsContextMapper userDetailsContextMapper(){
        return new LdapUserDetailsMapper() {
          @Override
            public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities){
              //List<GrantedAuthority> myAuth = new ArrayList<>();
              //myAuth.add(new SimpleGrantedAuthority("ROLE_USER"));
              UserDetails details = super.mapUserFromContext(ctx, username, authorities);
              return new CustomLdapUserDetails((LdapUserDetails) details, env, ctx);
          }
        };
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    /*  Fonctionne sur mon LDAP */
    /*auth.ldapAuthentication()
        .userSearchFilter("cn={0}")
        .groupSearchBase("ou=groupes")
        .contextSource().url("ldap://127.0.0.1:389/dc=maxcrc,dc=com");*/


    /*
     * Récupération de l'environnement
     */


        ParametresAppliDTO parametresAppliDTO = parametrerService.recupererParametresAppli(env.getRequiredProperty("nom.environnement"));

    /* Fonctionne sur AD Groupinfra */

        auth.ldapAuthentication()
                .ldapAuthoritiesPopulator(myCustomLdapAuthorities)
                .userDetailsContextMapper(userDetailsContextMapper())
                .userSearchFilter("cn={0}")
                //.groupSearchFilter("member={0}")
                .contextSource().url(parametresAppliDTO.getChaineConnexionLDAP())
                .managerDn(parametresAppliDTO.getCompteLDAP())
                .managerPassword(parametresAppliDTO.getMotDePasseLDAP());
/*

        auth.ldapAuthentication()
                .ldapAuthoritiesPopulator(myCustomLdapAuthorities)
                .userDetailsContextMapper(userDetailsContextMapper())
                .userSearchFilter("cn={0}")
                //.groupSearchFilter("member={0}")
                .contextSource().url(env.getRequiredProperty("ldap.url"))
                .managerDn(env.getRequiredProperty("ldap.user"))
                .managerPassword(env.getRequiredProperty("ldap.password"));

                */

    }
}
