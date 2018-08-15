package com.official.entity.reply;

import com.official.util.JSONUtil;

public class Reply {

	private Integer status;

	private String message;

	private Object data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(int i) {
		this.status = i;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JSONUtil.toJSONStr(this);
	}

}
