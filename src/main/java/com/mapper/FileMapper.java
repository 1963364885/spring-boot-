package com.mapper;

import com.pojo.file;
import org.apache.ibatis.annotations.Param;


public interface FileMapper {
    void insert1 (@Param("Pojo") file file1);
}
