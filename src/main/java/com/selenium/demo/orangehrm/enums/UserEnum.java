package com.selenium.demo.orangehrm.enums;

public enum UserEnum {
    SYSTEM_ADMIN("_ohrmSysAdmin_", "sysadmin"),
    ESS_USER("linda", "linda.anderson");

    public final String username;

    public final String password;

    UserEnum(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
