package com.sc.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 卖家
 * 
 * @author hp
 *
 */
@Data
@AllArgsConstructor
public class Seller implements Serializable {
	private static final long serialVersionUID = 4103435883524141625L;

	private Integer id;
	private Integer user_id;

}
