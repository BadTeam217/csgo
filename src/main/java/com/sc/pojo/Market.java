package com.sc.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 市场(上架)
 * 
 * @author hp
 *
 */
@Data
@AllArgsConstructor
public class Market implements Serializable {
	private static final long serialVersionUID = 4715640867960822025L;

	private Integer seller_id;
	private Integer item_id;
	private Double price;
	private Date datetime;

}
