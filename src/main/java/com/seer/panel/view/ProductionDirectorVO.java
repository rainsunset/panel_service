package com.seer.panel.view;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * @autheor ligw
 * @date 2018/9/3 11:37
 */
@ApiModel(description = "生产负责人")
public class ProductionDirectorVO implements Serializable {

	private String Name;

	private String phone;

	private String profilePhotepath;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProfilePhotepath() {
		return profilePhotepath;
	}

	public void setProfilePhotepath(String profilePhotepath) {
		this.profilePhotepath = profilePhotepath;
	}
}
