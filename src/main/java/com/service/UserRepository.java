package com.service;

import com.beans.User;

public interface UserRepository extends BaseRepository<User,Long>{
    User findByName(String name);
    User findOne(Long name);
    User save(User user);
}