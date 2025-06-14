package com.example.SpringBank.util;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswordHasher {
    private final Argon2 argon2;

    public PasswordHasher() {
        this.argon2 = Argon2Factory.create();
    }

    public String hashPassword(String password){
        return argon2.hash(2, 65536, 1, password.toCharArray());
    }

    public boolean verifyPassword(String password, String hash){
        return argon2.verify(hash, password.toCharArray());
    }
}
