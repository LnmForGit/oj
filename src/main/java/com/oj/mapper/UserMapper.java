package com.oj.mapper;

import com.oj.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

//注册Mapper
@Mapper
public interface UserMapper {
    //编写查询语句
    @Select("select * from user")
    //将查询结果的字段和User类的属性进行对应
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "userName", column = "user_name"),
        @Result(property = "userPassword", column = "user_password"),
        @Result(property = "sex", column = "user_sex")
    })
    //查询用户结果，返回User类型List
    public List<User> queryUserList();

    //编写插入语句
    @Insert("insert into user(user_name,user_password,user_sex) values(#{userName},#{userPassword},#{sex})")
    //保存插入对象之后将自增主键set到保存的对象当中
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn="id")
    //插入用户操作
    public int save(User user);

    //编写查询语句
    @Select("select * from user")
    //查询用户结果，返回Map类型List
    public List<Map> queryUserMapList();

}
