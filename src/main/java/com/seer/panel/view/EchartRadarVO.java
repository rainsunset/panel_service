package com.seer.panel.view;

import io.swagger.annotations.ApiModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @autheor ligw
 * @date 2018/9/3 11:04
 */
@ApiModel(description = "Ecahrt 雷达图 对应Model")
public class EchartRadarVO {

	private List<RadarIndicator> indicator;

	private List<Integer> value;

	public List<RadarIndicator> getIndicator() {
		return indicator;
	}

	public void setIndicator(List<RadarIndicator> indicator) {
		this.indicator = indicator;
	}

	public void addIndicator(String name, Integer max) {
		if (null == this.indicator) {
			this.indicator = new ArrayList<>();
		}
		this.indicator.add(new RadarIndicator(name, max));
	}

	public List<Integer> getValue() {
		return value;
	}

	public void setValue(List<Integer> value) {
		this.value = value;
	}

	class RadarIndicator{

		private String name;

		private Integer max;

		public RadarIndicator(){}

		public RadarIndicator(String name, Integer max) {
			this.name = name;
			this.max = max;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getMax() {
			return max;
		}

		public void setMax(Integer max) {
			this.max = max;
		}
	}

}
