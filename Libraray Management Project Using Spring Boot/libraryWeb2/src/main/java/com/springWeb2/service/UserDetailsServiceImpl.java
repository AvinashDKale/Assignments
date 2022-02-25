package com.springWeb2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

import com.springWeb2.entity.User;
import com.springWeb2.repository.UserRepository;
 
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
    }
 
}