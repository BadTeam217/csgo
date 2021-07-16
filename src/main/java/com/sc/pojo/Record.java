package com.sc.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 购买(记录)
 * 
 * @author hp
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record implements Serializable {
	private static final long serialVersionUID = 5589399097636788181L;

	private Integer buyer_id;
	private Integer seller_id;
	private Integer item_id;
	private Double price;
	private Date datetime;

}
