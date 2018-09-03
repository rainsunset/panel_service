package com.seer.panel.view;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @autheor ligw
 * @date 2018/9/1 10:55
 */
@ApiModel(description = "Ecahrt 饼图 对应Model")
public class EchartPieVO implements Serializable {

	private List<Serie> series;

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public void addSerie(List<Map<String,Object>> serieDatas) {
		if (null == this.series){
			this.series = new ArrayList<>();
		}
		Serie serie = new Serie();
		for (Map<String, Object> serieData : serieDatas) {
			serie.addSerieData((Integer) serieData.get("value"),(String) serieData.get("name"));
		}
		this.series.add(serie);
	}

	class Serie{

		private List<SerieData> data;

		public List<SerieData> getData() {
			return data;
		}

		public Serie() {}

		public Serie(List<SerieData> data) {
			this.data = data;
		}

		public void addSerieData(Integer value, String name){
			if (null == this.data){
				this.data = new ArrayList<>();
			}
			SerieData serieData = new SerieData(value, name);
			this.data.add(serieData);
		}

		class SerieData{
			private Integer value;

			private String name;

			public SerieData(){}

			public SerieData(Integer value, String name) {
				this.value = value;
				this.name = name;
			}

			public Integer getValue() {
				return value;
			}

			public void setValue(Integer value) {
				this.value = value;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}
		}
	}

}
