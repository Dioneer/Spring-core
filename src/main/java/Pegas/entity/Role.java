package Pegas.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Role {
    Admin, User, SuperUser;
    public static Optional<Role> find(String role){
        return Arrays.stream(values()).filter(i->i.name().equals(role)).findFirst();
    }
}

