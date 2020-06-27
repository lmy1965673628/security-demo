package com.ly.mapper;

import com.ly.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    @Select("select * from user Where username=#{username}")
    User findByUserName(@Param("username") String username);
}
