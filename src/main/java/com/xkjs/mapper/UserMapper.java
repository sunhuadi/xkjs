package com.xkjs.mapper;

import com.xkjs.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

   User getUserByName(String username);
}
