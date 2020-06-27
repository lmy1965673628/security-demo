package com.ly.service;

import com.ly.entity.User;
import com.ly.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("用户不存在");
        }

        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));


        return user;
    }
}
