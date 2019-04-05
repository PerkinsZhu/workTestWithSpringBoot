package com.service;

import com.beans.Role;

public interface RoleRepository extends BaseRepository<Role, Long> {
    Role save(Role role);
}