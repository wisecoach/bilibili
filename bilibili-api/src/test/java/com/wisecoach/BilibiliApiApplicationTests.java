package com.wisecoach;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wisecoach.mapper.TypeMapper;
import com.wisecoach.pojo.Archive;
import com.wisecoach.pojo.Member;
import com.wisecoach.pojo.Type;
import com.wisecoach.response.CustomResponseEntity;
import com.wisecoach.service.TypeService;
import com.wisecoach.util.SaltUtil;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

import javax.sql.DataSource;

@SpringBootTest
@MapperScan("com.wisecoach.mapper")
class BilibiliApiApplicationTests {

	@Autowired
	private TypeService typeService;
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
		redisTemplate.opsForValue().set("sss", 111);
		System.out.println(redisTemplate.opsForValue().get("sss"));
	}

}
