package com.cgihosting.service;

import com.cgihosting.repository.UserRepository;
import com.cgihosting.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by garnons on 07/12/2016.
 */

@Service("gererRoleService")
public class GererRoleServiceImpl implements GererRoleService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User searchUser(String username) {
        User user = userRepository.findByLogonName(username);
        return user;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> searchAllUsers() {
        List<User> userList;
        userList = (List<User>) userRepository.findAll();
        return userList;
    }

    @Override
    public User searchUserById(Integer id) {
        User user = userRepository.findById(id);
        return user;
    }

    @Override
    public Page<User> searchAllUsersByPage(Integer page, Integer maxRow) {
        Page<User> userPage;

        userPage = userRepository.findAll(new PageRequest(page,maxRow));
        return userPage;
    }

    @Override
    public Long totalUsers() {
        Long total;

        total = userRepository.count();
        return total;
    }
}
