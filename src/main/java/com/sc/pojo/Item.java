package com.sc.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 道具
 * 
 * @author hp
 *
 */
@Data
@AllArgsConstructor
public class Item implements Serializable {
	private static final long serialVersionUID = 2053619091097241878L;

	private Integer id;
	private String type;
	private String skin;
	private String quality;
}
