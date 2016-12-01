package com.example.security;

import org.springframework.core.env.Environment;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapUserDetails;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by garnons on 29/11/2016.
 */
public class CustomLdapUserDetails implements LdapUserDetails {

    private static final long serialVersionUID = 1L;

    private LdapUserDetails details;
    private Environment env;
    private String lastName;
    private String firstName;
    private String displayName;
    private String email;
    private String staffNumber;
    private String mobilePhone;
    private String officePhone;

    public CustomLdapUserDetails(LdapUserDetails details, Environment env, DirContextOperations ctx) {
        this.details = details;
        this.env = env;
        this.lastName = ctx.getStringAttribute("sn");
        this.firstName = ctx.getStringAttribute("givenname");
        this.displayName = ctx.getStringAttribute("displayname");
        this.email = ctx.getStringAttribute("mail");
        this.staffNumber = ctx.getStringAttribute("extensionattribute1");
        this.mobilePhone = ctx.getStringAttribute("mobile");
        this.officePhone = ctx.getStringAttribute("telephonenumber");
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public boolean isEnabled() {
        return details.isEnabled() && getUsername().equals(env.getRequiredProperty("ldap.username"));
    }

    public String getDn() {
        return details.getDn();
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return details.getAuthorities();
    }

    public String getPassword() {
        return details.getPassword();
    }

    public String getUsername() {
        return details.getUsername();
    }

    public boolean isAccountNonExpired() {
        return details.isAccountNonExpired();
    }

    public boolean isAccountNonLocked() {
        return details.isAccountNonLocked();
    }

    public boolean isCredentialsNonExpired() {
        return details.isCredentialsNonExpired();
    }
}
