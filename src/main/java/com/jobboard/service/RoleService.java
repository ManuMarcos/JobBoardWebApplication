package com.jobboard.service;

import com.jobboard.domain.Role;
import com.jobboard.dto.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAllRoles();
}
