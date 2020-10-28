package com.wisecoach.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wisecoach.annotation.Cacheable;
import com.wisecoach.pojo.Archive;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Mapper
@Repository
@Cacheable
public interface ArchiveMapper extends BaseMapper<Archive> {
}
