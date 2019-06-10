package com.mapper;


import com.pojo.Demands;
import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemandsMapper {
    List<Demands> cha(@Param("Pojo") Demands demands);
    List<Demands>creatorcha(@Param("Pojo")Demands demands);
    List<User>ucha(@Param("Pojo")User user);
    void zhen (@Param("Pojo") Demands demands1);
    void gai (@Param("Pojo") Demands demands);
    void shan(@Param("Pojo") Demands demands);
    void duoshan(@Param("Pojo") Demands demands);
    List<Demands>  dcha(@Param("Pojo") Demands demands);
}
