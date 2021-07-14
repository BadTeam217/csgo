package com.sc.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户对象
 * 
 * @author hp
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 7138890773335711008L;

	private Integer id;
	private String name;
	private String password;
	private String account;

}
