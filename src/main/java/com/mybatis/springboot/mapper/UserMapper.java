package com.mybatis.springboot.mapper;

import com.mybatis.springboot.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> findAll();

    @Insert("INSERT INTO user (name, salary) VALUES (#{name}, #{salary})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    void insert(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void delete(Integer id);

    @Update("UPDATE user SET name = #{name}, salary = #{salary} WHERE id = #{id}")
    void update(User user);
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Integer id);
}
