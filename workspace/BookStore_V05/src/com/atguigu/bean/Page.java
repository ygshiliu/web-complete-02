package com.atguigu.bean;

import java.util.List;

/**
 * 文件名: Page.java
 * 描述: 封装分页相关的数据信息
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月14日 下午3:55:56
 */
public class Page<T> {
	/**
	 * 显示的数据集合 
	 */
	private List<T> list;
	/**
	 * 数据库中的总记录数
	 */
	private int totalCount;
	/**
	 * 当前要显示的页面
	 */
	private int pageNo;
	/**
	 * 每页要显示的条数
	 */
	private int pageSize;
	/**
	 * 总页数 
	 */
	//private int totalPage;
	/**
	 * 计算出来的索引值
	 */
	//private int index;
	/**
	 * 保存路径来源
	 */
	private String path;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getPageNo() {
		//如果当前页小于等1，则设置为1
		if(pageNo <= 1){
			pageNo=1;
		}
		//如果当前页大于等于总页数，则设置为总页数
		if(pageNo>=getTotalPage()){
			pageNo = getTotalPage();
		}
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 总记录数 / 显示条数 = 总页数
	 * 10		2		5
	 * 9		2		5
	 * 8		2		4
	 * 7		2		4
	 * 6		2		3
	 * 5		2		3
	 * 
	 * @return
	 */
	public int getTotalPage() {
		//统计总页数
		int count = getTotalCount()/getPageSize();
		if( getTotalCount()%getPageSize() != 0){
			count++;
		}
		return count;
	}
	
	/**
	 * (当前页-1) * 每页条数 = 索引
	 * 		1		2		0
	 * 		2		2		2
	 * 		3		2		4
	 * 		4		2		6
	 * @return
	 */
	public int getIndex() {
		return (getPageNo()-1)*getPageSize();
	}
	
}
