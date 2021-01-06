package com.xkjs.mapper;

import com.xkjs.pojo.Activity;
import com.xkjs.pojo.Bala;
import com.xkjs.pojo.signUp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SignUpMapper {
    List<Activity> findAllByUid(int uid);
    int insertJoin(signUp signUp);
    int updataS(signUp signUp);
    signUp findSByUidAid(signUp signUp);
    List<Bala> findAllCheck();
}
