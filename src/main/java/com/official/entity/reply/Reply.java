package com.official.entity.reply;

import com.official.util.JsonUtil;

/**
 * 回复类
 *
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
public class Reply {

	private Integer status;

	private String message;

	private Object data;

	public Reply() {
		super();
	}

	public Reply(Integer status) {
		super();
		this.status = status;
	}

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
		return JsonUtil.toJSONStr(this);
	}

}
