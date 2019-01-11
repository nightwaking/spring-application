package com.myproject.web;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FilledList<T> {
	private Class<T> type;
	public FilledList(Class<T> type) {
		this.type = type;
	}
	public List<T> create(int intElement) {
		List<T> result = new ArrayList<>();
		for (int i = 0; i < intElement; i++){
			try {
				result.add(type.newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	private static final String V5_SINGLE = "0010";
	public static void main(String[] args) {
		LightSensorModelStatus modelStatus = new LightSensorModelStatus();
		System.out.println(Objects.equals(getSensorCodePrefix("000068719479682"), V5_SINGLE));
	}

	private static String getSensorCodePrefix(String sensorCode){
		String source = sensorCode;
		if (source == null)
			return null;
		String  hexSensorCode = StringUtils.leftPad(String.valueOf(Long.toHexString((new BigDecimal(source).longValue()))), 12, '0');
		return hexSensorCode.substring(0, 4);
	}
}

class CountInteger {
	private static long counter;
	private final long id = counter ++;
}
@Data
class LightSensorModelStatus {
	private Boolean lampControlModel; // 灯控模块
	private Boolean alarmModel; // 报警模块
	private Boolean angleModel; // 角度模块
	private Boolean temperatureModel; // 温度模块
	private Boolean constantLightModel; // 恒照度模块
	private Boolean waterModel; // 水浸模块
	private Boolean leakCurrentModel; // 漏电流模块
}
