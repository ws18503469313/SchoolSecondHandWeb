package com.ws.entity;

import java.util.List;
/**
 * 
 * @author polunzi
 *
 * @param <T>	��Ҫ��ҳ��ѯ��ʵ����
 * @pageSize	ÿҳ������
 * @pageIndex	��ǰ�ڼ�ҳ
 * @totalPage	��ҳ��
 * @totalRecord	������
 * @datas		��ҳ������ľ�������
 */
public class Pager<T> {
	private int pageSize;//ÿҳ������
	private int pageIndex;//��ǰ�ڼ�ҳ
	private int totalPage;//��ҳ��
	private int totalRecord;//�ܼ�¼��
	
	private List<T> datas;//���þ��������

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
