package com.mh.hisplat.service;

import com.mh.hisplat.bean.User;
import com.mh.hisplat.entry.CacheUser;


import java.util.List;
import java.util.Map;
public interface UserService {
    User findByUsername(String username);

    CacheUser login(String username, String password);

    void logout();

    Map reg(User user);

    void update(User user);

    List<User> selectBy(User user);
}
