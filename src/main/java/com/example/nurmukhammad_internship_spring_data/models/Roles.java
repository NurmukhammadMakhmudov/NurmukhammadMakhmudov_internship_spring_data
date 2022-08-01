package com.example.nurmukhammad_internship_spring_data.models;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Roles {
    ADMIN(Set.of(Permission.PERMISSION_ADMIN)),
    MANAGER(Set.of(Permission.PERMISSION_MANAGER)),
    MENTOR(Set.of(Permission.PERMISSION_MENTOR));

    private final Set<Permission> permissionSet;


    Roles(Set<Permission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<Permission> getPermissionSet() {
        return permissionSet;
    }
    public Set<SimpleGrantedAuthority> getAuth(){
        return getPermissionSet().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}


