package com.mapper;

import com.pojo.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {
    List<Task> cha(@Param("Pojo") Task task);
    List<Task>creatorcha(@Param("Pojo")Task demands);
    List<Task>dcha(@Param("Pojo")Task demands);
    void zhen(@Param("Pojo") Task task);
    void shan(@Param("Pojo") Task task);
    void gai(@Param("Pojo") Task task);
    void wan(@Param("Pojo") Task task);

}
