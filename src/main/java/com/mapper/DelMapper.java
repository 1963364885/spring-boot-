package com.mapper;

import com.pojo.DeleteLog;
import org.apache.ibatis.annotations.Param;

public interface DelMapper {
    void insertIntoDatabase(@Param("pojo") DeleteLog deletelog);
}
