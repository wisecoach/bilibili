package com.wisecoach.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wisecoach.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TypeMapper extends BaseMapper<Type> {

}
