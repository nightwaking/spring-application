package com.myproject.web;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.myproject.web.dao.QuerySensorMessageData;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.http2.ByteUtil;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AlipayTest {

	public static void main(String[] args) {
		String hexData = "3C 3C 3C 5A 28 05 D2 04 53 00 15 02 00 00 10 00 03 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 10 0E B4 65 93 73 33 16 7F 11 11 06 11 00 50 11 02 14 11 04 00 11 06 46 11 08 32 11 0A 00 00 00 00 00 00 00 00 00 00 00 00 00 01 00 00 00 00 00 00 00 00 00 FF FF FF FF FF FF 00 49 E2 ED";
		byte[] byteDatas = hexString2Bytes(hexData);
		decodeQuerySensor(byteDatas);
	}
	public static void decodeQuerySensor(byte[] bytes) {
		byte[] sensorCodeArray = new byte[6];
		System.arraycopy(bytes, 10, sensorCodeArray, 0, 6);

		int dataIndex = 17;
		String byteString = bytesToHexFun(bytes);

		dataIndex += 3;

		byteString.substring(dataIndex * 2, (dataIndex + 3) * 2);
		dataIndex += 3;

		byteString.substring(dataIndex * 2, (dataIndex + 8) * 2);
		dataIndex += 8;

		// 设备型号，1字节
		byte sensorModel = bytes[dataIndex];
		dataIndex += 1;

		//固件版本号
		int version = bytes[dataIndex] & 0xff;
		dataIndex += 1;

		dataIndex += 1;

		//心跳间隔 2 字节
		int heartBeat = (bytes[dataIndex] & 0xff) + (bytes[dataIndex + 1] << 8 & 0xff00);
		dataIndex += 2;
		dataIndex += 6;

		// 模式状态，1字节

		dataIndex += 1;

		dataIndex += 2;

		String lightLine = "";
		int point = bytes[dataIndex];
		for (int i = 1; i <= point; i++){ ;
			int count = dataIndex + 1 + (i - 1) * 3;
			lightLine += String.valueOf(bytes[count]) + ":";
			lightLine += String.valueOf(bytes[count + 1]) + "-";
			lightLine += String.valueOf(bytes[count + 2]);
			if ( i < point) {
				lightLine += ";";
			}
		}

		dataIndex += 31;


		dataIndex += 2;


		dataIndex += 1;

		dataIndex += 1;


		dataIndex += 2;


		dataIndex += 1;


		dataIndex += 1;


		dataIndex += 2;


		dataIndex += 2;


		dataIndex += 1;


		dataIndex += 1;


		dataIndex += 1;
	}

	private static String getSensorCodeV5(byte[] bytes)  {

		String sensorCode = bytes2HexString(bytes).substring(10, 12);
		sensorCode += bytes2HexString(bytes).substring(8, 10);
		sensorCode += bytes2HexString(bytes).substring(6, 8);
		sensorCode += bytes2HexString(bytes).substring(4, 6);
		sensorCode += bytes2HexString(bytes).substring(2, 4);
		sensorCode += bytes2HexString(bytes).substring(0, 2);

		String sensorCodeDesc = hex2DecAndLeftPad(sensorCode, 15, '0');
		return sensorCodeDesc;
	}

	private static String hex2DecAndLeftPad(String hex, int length, char padChar){
		if (hex == null || hex.length() != 12)
			return  null;
		String source = hex;
		if(source.startsWith("0x")){
			source = source.substring(2);
		}
		return StringUtils.leftPad(String.valueOf(new BigInteger(source, 16)), length, padChar);
	}

	private static String bytes2HexString(byte[] data) {
		return bytes2HexString(data, null);
	}

	private static String bytes2HexString(byte[] data, final String separator) {
		StringBuilder sb = new StringBuilder();
		for (byte b : data) {
			sb.append(byte2HexString(b));
			if (StringUtils.isNotBlank(separator))
				sb.append(separator);
		}
		return sb.toString();
	}

	private static String byte2HexString(byte b) {
		String s = Integer.toHexString(b & 0xff);
		if (s.length() == 1)
			s = "0" + s;
		return s.toUpperCase();
	}

	private static String bytesToHexFun(byte[] bytes) {
		StringBuilder buf = new StringBuilder(bytes.length);
		for(byte b : bytes) { // 使用String的format方法进行转换
			buf.append(new Integer(b & 0xff));
		}

		return buf.toString();
	}

	private static byte[] hexString2Bytes(final String hexStr) {
		if (StringUtils.isBlank(hexStr))
			return null;

		String str = hexStr.replaceAll(" ", "");

		int length = str.length() / 2;
		byte[] result = new byte[length];
		for (int i = 0; i < length; i++) {
			String s = str.substring(i * 2, i * 2 + 2);
			result[i] = (byte) (Integer.valueOf(s, 16) & 0xff);
		}
		return result;
	}
}
