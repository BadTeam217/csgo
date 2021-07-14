package com.sc.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * 买家
 * @author hp
 *
 */
@Data
@AllArgsConstructor
public class Buyer implements Serializable {
	private static final long serialVersionUID = -4006663698701035074L;

	private Integer id;
	private Integer user_id;

}
