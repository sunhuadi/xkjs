package com.xkjs.mapper;

import com.xkjs.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SignUpMapper {
    List<Activity> findAllByUid(int uid);
}
