package com.seer.panel.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @autheor ligw
 * @date 2018/9/1 12:39
 */
public class EchartHeatmapVO implements Serializable {

	private List<String> hours;

	private List<String> days;

	private List<int[]> data;

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

	public void addData(int y,int x,int val) {
		if (null == this.data){
			this.data = new ArrayList<>();
		}
		int[] a = {y, x, val};
		this.data.add(a);
	}
}
