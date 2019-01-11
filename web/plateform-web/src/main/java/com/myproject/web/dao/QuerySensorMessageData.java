package com.myproject.web.dao;

import lombok.Data;

@Data
public class QuerySensorMessageData {
	private int loop;
	private String customerCode;
	// 设备编号
	private String sensorCode;
	private String poleCode;
	// 设备类型
	private int sensorModelCode;
	// 硬件版本
	private int hardwareVersion;
	// 通信版本号编号
	private int communicateEquipmentVersion;
	//心跳间隔
	private int heartBeatInterval;
	// 坐标
	private String coordinate;
	//IP地址
	private String ip;
	//端口
	private int port;
	//角度模块
	private boolean angleOn;
	//温度模块打开
	private boolean temperaTurnOn;
	//恒照度模块打开
	private boolean fixLightOn;
	//水浸模块打开
	private boolean waterOn;
	//漏电模块打开
	private boolean leakCurrentOn;
	//计量模块
	private boolean calculateOn;
	// 报警模块
	private boolean alarmOn;
	//灯控模块打开
	private boolean lightControlOn;
	// 恒照度系数
	private int constantLightRate;
	// 调光曲线
	private String lightLine;
	// 漏电流矫正系数
	private int leakCurrentRate;
	// 电压报警参数
	private int voltageWarnParam;
	private int volWarnParamUpRate;
	private int volWarnParamDownRate;
	// 电流报警参数
	private int currentWarnParam;
	private int curWarnParamUpRate;
	private int curWarnParamDownRate;
	// 漏电流报警参数
	private int leakWarnParam;
	// 温度报警参数
	private int temWarnParam;
	// 角度报警参数
	private int angleWarnParam;
	private int angleWarnParamUpRate;
	private int angleWarnParamDownRate;
}

