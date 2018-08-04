package com.ws.entity;

import java.util.List;
/**
 * 
 * @author polunzi
 *
 * @param <T>	需要分页查询的实体类
 * @pageSize	每页多少条
 * @pageIndex	当前第几页
 * @totalPage	总页数
 * @totalRecord	总条数
 * @datas		分页查出来的具体结果集
 */
public class Pager<T> {
	private int pageSize;//每页多少条
	private int pageIndex;//当前第几页
	private int totalPage;//总页数
	private int totalRecord;//总记录数
	
	private List<T> datas;//放置具体的数据

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "Pager [pageSize=" + pageSize + ", pageIndex=" + pageIndex
				+ ", totalPage=" + totalPage + ", totalRecord=" + totalRecord
				+ ", datas=" + datas + "]";
	}
	
	

}
