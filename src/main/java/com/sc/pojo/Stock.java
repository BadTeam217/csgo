package com.sc.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 仓库(拥有)
 * 
 * @author hp
 *
 */
@Data
@AllArgsConstructor
public class Stock implements Serializable {
	private static final long serialVersionUID = -318257508806879909L;

	private Integer user_id;
	private Integer item_id;

}
