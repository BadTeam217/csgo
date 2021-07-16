package com.sc.vo;

import java.io.Serializable;

import com.sc.pojo.Item;
import com.sc.pojo.User;

import lombok.Data;

/**
 * 用户商品
 * 
 * @author hp
 *
 */
@Data
public class UserItemVo implements Serializable {
	private static final long serialVersionUID = 4377751870847839568L;

	private User user;
	private Item item;
}
