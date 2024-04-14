package Pegas.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Optional;

public enum Role implements GrantedAuthority {
    ADMIN,
    USER,
    SUPERUSER;
    public static Optional<Role> find(String role){
        return Arrays.stream(values()).filter(i->i.name().equals(role)).findFirst();
    }

    @Override
    public String getAuthority() {
        return name();
    }
}

