package com.official;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * 启动App
 * <p>
 * <p>
 *
 * @author huanghuapeng 2017年11月1日
 * @since 1.0
 */
@SpringBootApplication
public class App {
	private static final Logger log = LoggerFactory.getLogger(App.class);

	/**
	 * 启动App
	 *
	 * @param args
	 *            启动参数
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/**
	 * 系统初始化启动方法
	 */
	@PostConstruct
	public void sysInit() {
		log.info("System init method in App#sysInit() ");
	}

}
