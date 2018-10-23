package com.hzit;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageHelper;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.hzit.mapper")
public class GoodsApplication8201 {
 public static void main(String[] args) {
	 SpringApplication.run(GoodsApplication8201.class, args);
 
 }
	//配置mybatis的分页插件pageHelper
	    @Bean
	    public PageHelper pageHelper(){
	        //分页插件
	        PageHelper pageHelper = new PageHelper();
	        Properties properties = new Properties();
	        properties.setProperty("offsetAsPageNum", "true");
	        properties.setProperty("rowBoundsWithCount", "true");
	        properties.setProperty("reasonable", "true");
	        properties.setProperty("supportMethodsArguments", "true");
	        properties.setProperty("returnPageInfo", "check");
	        //properties.setProperty("params", "pageNum=page;pageSize=limit;orderBy=orderBy");
	        pageHelper.setProperties(properties);
	        return pageHelper;
	    }
}
