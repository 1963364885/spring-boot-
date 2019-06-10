package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import javax.xml.transform.Source;
import java.util.List;

/**
 * Created on 2018.08.14.
 */
public interface UserMapper {
    List<User> login(@Param("Pojo") User user);
    List<User> zaixian(@Param("Pojo") User user);
    void register (@Param("Pojo") User user);
    void update (@Param("Pojo") User user);
    void delete(@Param("Pojo") User user);
    void zhuang (@Param("Pojo") User user);
    List<User> cha(@Param("Pojo") User user);
}
