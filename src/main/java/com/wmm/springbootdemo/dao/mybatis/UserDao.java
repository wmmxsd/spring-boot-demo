package com.wmm.springbootdemo.dao.mybatis;

import com.wmm.springbootdemo.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangmingming160328
 * @Description 用户dao层（{@Repository}可以消去依赖注入的报错信息）
 * @date @2020/5/12 14:23
 */
@Repository
@Mapper
public interface UserDao {
    /**
     * 通过名字查询用户信息
     *
     * @param name 用户名
     * @return 用户
     */
    @Select("SELECT * FROM user WHERE name = #{name}")
    List<User> findUserByName(@Param("name") String name);

    /**
     * 查询所有用户信息
     *
     * @return 所有用户
     */
    @Select("SELECT * FROM user")
    List<User> findAllUser();

    /**
     * 插入用户信息
     *
     * @param name 用户名
     * @param age 年龄
     * @param money 钱
     */
    @Insert("INSERT INTO user(name, age,money) VALUES(#{name}, #{age}, #{money})")
    void insertUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money);

    /**
     * 根据 id 更新用户信息
     * @param id 用户id
     * @param name 用户名
     * @param age 年龄
     * @param money 钱
     */
    @Update("UPDATE  user SET name = #{name},age = #{age},money= #{money} WHERE id = #{id}")
    void updateUser(@Param("id") int id, @Param("name") String name, @Param("age") Integer age, @Param("money") Double money);

    /**
     * 根据 id 删除用户信息
     * @param id 用户id
     */
    @Delete("DELETE from user WHERE id = #{id}")
    void deleteUser(@Param("id") long id);
}
