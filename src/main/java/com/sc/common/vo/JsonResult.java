package com.sc.common.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class JsonResult implements Serializable {
	private static final long serialVersionUID = -993375706215222253L;

	private int state = 1;
	private String message = "ok";
	private Object data;

	public JsonResult(String message) {
		this.message = message;
	}

	public JsonResult(Object data) {
		this.data = data;
	}

	public JsonResult(Throwable e) {
		this.state = 0;
		this.message = e.getMessage();
	}
}
