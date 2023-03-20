package com.jobboard.service;

import com.jobboard.dao.RoleDao;
import com.jobboard.domain.Role;
import com.jobboard.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<RoleDto> findAllRoles() {
        List<RoleDto> rolesDtos = new ArrayList<>();
        List<Role> roles = roleDao.findAll();
        for (Role ri : roles){
            RoleDto roleDto = new RoleDto(ri.getId(), ri.getName().toString());
            rolesDtos.add(roleDto);
        }
        return rolesDtos;
    }
}
