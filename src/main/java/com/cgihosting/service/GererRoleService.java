package com.cgihosting.service;

import com.cgihosting.domain.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by garnons on 07/12/2016.
 */
public interface GererRoleService extends Serializable{
    public User searchUser(String username);

    public User searchUserById(Integer id);

    public void saveUser(User user);

    public List<User> searchAllUsers();
}
