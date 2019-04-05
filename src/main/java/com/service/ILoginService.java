package com.service;


import com.beans.Role;
import com.beans.User;

import java.util.Map;

public interface ILoginService {
    User addUser(Map<String, Object> map);
    Role addRole(Map<String, Object> map);
    User findByName(String  name);
}
