package com.xkjs.mapper;

import com.xkjs.pojo.Test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestMapper {

    List<Test> testqurry();
}
