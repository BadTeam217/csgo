package com.sc.vo;

import java.io.Serializable;
import java.util.Date;

import com.sc.pojo.Item;
import com.sc.pojo.User;

import lombok.Data;

@Data
public class MarketVo implements Serializable {
	private static final long serialVersionUID = -324180090095298465L;

	private User user;
	private Item item;
	private Double price;
	private Date datetime;
}
