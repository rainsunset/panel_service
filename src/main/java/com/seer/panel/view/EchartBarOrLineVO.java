package com.seer.panel.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @autheor ligw
 * @date 2018/9/1 10:31
 */

public class EchartBarOrLineVO implements Serializable {

	private List<String> xAxisData;

	private String yAxisname;

	private List<Serie> series;

	public List<String> getxAxisData() {
		return xAxisData;
	}

	public void setxAxisData(List<String> xAxisData) {
		this.xAxisData = xAxisData;
	}

	public String getyAxisname() {
		return yAxisname;
	}

	public void setyAxisname(String yAxisname) {
		this.yAxisname = yAxisname;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public void addSeriesData(List<Integer> serieData) {
		Serie serie = new Serie(serieData);
		if (null == this.series){
			this.series = new ArrayList<>();
		}
		this.series.add(serie);
	}

	class Serie{

		private List<Integer> data;

		public Serie(){}

		public Serie(List<Integer> serieData){
			this.data = serieData;
		}

		public List<Integer> getData() {
			return data;
		}

		public void setData(List<Integer> data) {
			this.data = data;
		}
	}




}
