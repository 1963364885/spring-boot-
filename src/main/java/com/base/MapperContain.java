package com.base;

import com.mapper.*;
//import com.mapper.FileMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by li on 2017/11/27.
 */
@Mapper
public class MapperContain {
    //用户
    @Autowired
    public UserMapper userMapper;
    @Autowired
    public ApplicationContext applicationContext;
    @Autowired
    public DelMapper delMapper;
   @Autowired
    public FileMapper fileMapper;
   @Autowired
    public DemandsMapper demandsMapper;
    @Autowired
    public TaskMapper taskMapper;

}
