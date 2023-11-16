package com.prowerblog.prowerblog.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prowerblog.prowerblog.Model.User;
import com.prowerblog.prowerblog.Repository.RoleRepository;
import com.prowerblog.prowerblog.Repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    private static final String USER_ROLE = "ROLE_USER";

    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository=roleRepository;
    }

    public User signup(User nUser) {
        User user = new User();
        user.setUsername(nUser.getUsername());
        user.setEmail(nUser.getEmail());
        user.setFirstName(nUser.getFirstName());
        user.setLastName(nUser.getLastName());
        user.setActive(1);
        user.setPassword(passwordEncoder.encode(nUser.getPassword()));
        user.setRoles(Collections.singletonList(roleRepository.findByRole(USER_ROLE)));
        return userRepository.saveAndFlush(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> ouser = userRepository.findOneByUsername(username);
          if(!ouser.isPresent()){
                 new UsernameNotFoundException("User not exists by Username");
               }
               User user = ouser.get();
               List<GrantedAuthority> grantedAuthorities = user
                       .getRoles()
                       .stream()
                       .map(roles -> new SimpleGrantedAuthority(roles.getRole()))
                       .collect(Collectors.toList());
       
 return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
    }


