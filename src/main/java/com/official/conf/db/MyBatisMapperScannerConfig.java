package com.official.conf.db;

import java.util.Properties;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.official.util.MyMapper;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * MyBatis扫描接口
 *
 * <p>
 * 
 * 使用的tk.mybatis.spring.mapper.MapperScannerConfigurer <br/>
 * 如果你不使用通用Mapper，可以改为: org.mybatis.spring.mapper.MapperScannerConfigurer;
 *
 *
 * 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解@AutoConfigureAfter
 *
 * @author 3306 2017年10月17日下午8:42:03
 *
 */
@Configuration
@AutoConfigureAfter(MybatisAutoConfiguration.class)
public class MyBatisMapperScannerConfig {

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.official.mapper");
		Properties properties = new Properties();
		// 这里要特别注意，不要把MyMapper放到 basePackage 中，也就是不能同其他Mapper一样被扫描到。
		properties.setProperty("mappers", MyMapper.class.getName());
		properties.setProperty("notEmpty", "false");
		properties.setProperty("IDENTITY", "MYSQL");
		mapperScannerConfigurer.setProperties(properties);
		return mapperScannerConfigurer;
	}

}
