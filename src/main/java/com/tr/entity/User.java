package com.tr.entity;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String id;

    private String firstName;
    private String lastName;

    public User() {}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id = %s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || !(object instanceof User)) {
            return false;
        }

        User userToComapare = (User)object;
        if (this.firstName.equals(userToComapare.firstName) && this.lastName.equals(userToComapare.lastName)) {
            return true;
        }

        return result;
    }
}
