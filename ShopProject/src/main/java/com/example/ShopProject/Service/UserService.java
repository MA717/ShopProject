package com.example.ShopProject.Service;

import com.example.ShopProject.Entity.Role;
import com.example.ShopProject.Entity.User;
import com.example.ShopProject.Repository.RoleRepository;
import com.example.ShopProject.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UserService implements UserDetailsService {
    UserRepository userRepository;
    RoleRepository roleRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role{} to user {} " , roleName , username );
        User user = userRepository.findUserByUsername(username);
        Role role = roleRepository.findRoleByName(roleName);
//        user.getRoles().add(role);
    }

    public User getUser(String username) {

        return userRepository.findUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if( user == null) {
            log.error("User cannot be found");
            throw new UsernameNotFoundException("User cannot be found");
        }
        else{
            log.info("User found in the database{}" , username);
        }
        Collection<SimpleGrantedAuthority>autherties = new ArrayList<>();
        autherties.add(new SimpleGrantedAuthority(user.getRole()));
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),autherties);
    }

}
