package com.oj.mapper;

import com.oj.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper {
    @Select("select * from user")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "userName", column = "user_name"),
        @Result(property = "userPassword", column = "user_password"),
        @Result(property = "sex", column = "user_sex")
    })
    public List<User> queryUserList();
    @Insert("insert into user(user_name,user_password,user_sex) values(#{userName},#{userPassword},#{sex})")
    public int save(User user);
}
