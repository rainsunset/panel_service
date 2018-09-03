package com.seer.panel.view;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @autheor ligw
 * @date 2018/9/1 12:39
 */
@ApiModel(description = "Ecahrt 热力图 对应Model")
public class EchartHeatmapVO implements Serializable {

	private List<String> hours;

	private List<String> days;

	private List<int[]> data;

	private Integer max;

	public List<String> getHours() {
		return hours;
	}

	public void setHours(List<String> hours) {
		this.hours = hours;
	}

	public List<String> getDays() {
		return days;
	}

	public void setDays(List<String> days) {
		this.days = days;
	}

	public List<int[]> getData() {
		return data;
	}

	public void setData(List<int[]> data) {
		this.data = data;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public void addData(int x,int y,int val) {
		if (null == this.data){
			this.data = new ArrayList<>();
		}
		int[] a = {x, y, val};
		this.data.add(a);
	}
}
