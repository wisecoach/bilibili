package com.wisecoach;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wisecoach.mapper.TypeMapper;
import com.wisecoach.pojo.Archive;
import com.wisecoach.pojo.Type;
import com.wisecoach.service.TypeService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
@MapperScan("com.wisecoach.mapper")
class BilibiliApiApplicationTests {

	@Autowired
	private TypeService typeService;

	@Test
	void contextLoads() {
	}

}
