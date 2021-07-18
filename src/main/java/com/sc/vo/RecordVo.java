package com.sc.vo;

import java.io.Serializable;
import java.util.Date;

import com.sc.pojo.Item;
import com.sc.pojo.User;

import lombok.Data;

@Data
public class RecordVo implements Serializable {
	private static final long serialVersionUID = -7158418150039644398L;

	private User userSeller;
	private User userBuyer;
	private Item item;
	private Double price;
	private Date datetime;
}
