package com.hzit.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.ShopGoods;
import com.hzit.GoodsApplication8201;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=GoodsApplication8201.class)
public class RedisTest {

	@Autowired
	private RedisTemplate redisTemplate;
	@Test
	public void test() {
		ShopGoods shopGoods=new ShopGoods();
		shopGoods.setGoodsName("棉花糖");
        HashOperations<String, Integer, Object> hash=redisTemplate.opsForHash();
        hash.put("cart", 11,shopGoods );
        System.out.println(hash.get("cart", 11));
	}
}
