package cn.itcast.shop.utils;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	private Integer page; //��ǰҳ
	private Integer pageCount; //��ҳ��
	private Integer total; //�ܼ�¼��
	private Integer pagesize; //ÿҳ��ʾ����Ŀ
	private List<T> proList = new ArrayList<T>(); //��Ʒ����
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public List<T> getProList() {
		return proList;
	}
	public void setProList(List<T> proList) {
		this.proList = proList;
	}
	
	
}
