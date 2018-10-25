package com.hzit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.hzit.mapper")
public class MemberApplication8202 {
	public static void main(String[] args) {
		// 第一个参数:入口类的字节码对象  第二个参数:main方法的参数
		// 担心启动的时候需要某些参数，springboot可以从main方法中获取启动参数
		SpringApplication.run(MemberApplication8202.class, args); 
	}
}
