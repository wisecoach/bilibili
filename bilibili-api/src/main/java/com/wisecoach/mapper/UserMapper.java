package com.wisecoach.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wisecoach.pojo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<Member> {
}
