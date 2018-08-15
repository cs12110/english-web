package com.official.conf.mvc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.official.util.JSONUtil;

/**
 * 上传文件保存路径
 *
 * <p>
 * 
 * @author huanghuapeng 2017年11月6日
 * @see
 * @since 1.0
 */
@Component
@ConfigurationProperties(prefix = "pic")
public class SavePictureConf {

	private String saveDir;

	public String getSaveDir() {
		return saveDir;
	}

	public void setSaveDir(String saveDir) {
		this.saveDir = saveDir;
	}

	@Override
	public String toString() {
		return JSONUtil.toJSONStr(this);
	}

}
