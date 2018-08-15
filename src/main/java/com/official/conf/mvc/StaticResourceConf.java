package com.official.conf.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 设置系统静态资源映射文件
 * <p>
 * <p>
 *
 * @author huanghuapeng 2017年11月6日
 * @see
 * @since 1.0
 */
@Configuration
public class StaticResourceConf extends WebMvcConfigurerAdapter {

	@Autowired
	private SavePictureConf savePictrueConf;

	/**
	 * 设置资源路径
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		/*
		 * 设置static文件映射路径
		 */
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

		/*
		 * 设置图片上传存放映射路径
		 *
		 * 需要用file:///来做映射
		 */
		registry.addResourceHandler("/pics/**").addResourceLocations("file:///" + savePictrueConf.getSaveDir());

	}

}
