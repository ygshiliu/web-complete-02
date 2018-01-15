package com.atguigu.user;
/**
 * 文件名: Address.java
 * 描述: 
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月13日 下午2:17:45
 */
public class Address {
	
	private String city;
	private String district;
	private String province;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Address(String city, String district, String province) {
		super();
		this.city = city;
		this.district = district;
		this.province = province;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", district=" + district
				+ ", province=" + province + "]";
	}
	
	
}
