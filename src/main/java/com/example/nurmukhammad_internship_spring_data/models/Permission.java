package com.example.nurmukhammad_internship_spring_data.models;

public enum Permission {
    PERMISSION_ADMIN("ADMIN"),
    PERMISSION_MANAGER("MANAGER"),
    PERMISSION_MENTOR("MENTOR");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

}
