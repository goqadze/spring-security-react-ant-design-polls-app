package com.example.polls.config;

import com.example.polls.model.Role;
import com.example.polls.model.RoleName;
import com.example.polls.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    RoleRepository roles;

    @Autowired
    public DataInitializer(RoleRepository roleRepository) {
        this.roles = roleRepository;
    }


    @EventListener(value = ContextRefreshedEvent.class)
    public void init() {
        initRoles();
    }

    private void initRoles() {
        Role roleUser = new Role(RoleName.ROLE_USER);
        Role roleAdmin = new Role(RoleName.ROLE_ADMIN);

        this.roles.save(roleUser);
        this.roles.save(roleAdmin);
    }
}
