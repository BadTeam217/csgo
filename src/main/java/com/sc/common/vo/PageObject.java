package com.sc.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageObject<T> implements Serializable {
	private static final long serialVersionUID = -8495366802896329942L;
	/** 封装查询到的当前页记录 */
	private List<T> records;
	/** 总记录数 */
	private Long rowCount;
	/** 总页数 */
	private Integer pageCount;
	/** 页面大小 */
	private Integer pageSize;
	/** 当前页码值 */
	private Long pageCurrent;

	public PageObject(List<T> records, Long rowCount, Integer pageSize, Long pageCurrent) {
		super();
		this.records = records;
		this.rowCount = rowCount;
		this.pageSize = pageSize;
		this.pageCurrent = pageCurrent;
		// 计算总页数
		this.pageCount = (int) (rowCount / pageSize);
		if (rowCount % pageSize != 0) {
			this.pageCount++;
		}
	}

}
