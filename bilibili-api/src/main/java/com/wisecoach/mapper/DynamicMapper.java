package com.wisecoach.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wisecoach.pojo.Dynamic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DynamicMapper extends BaseMapper<Dynamic> {
}
