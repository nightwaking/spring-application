package com.myproject.web.server;

import lombok.val;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Hex2Dec {
	public static void main(String[] args) {
//		String desString = hex2DecAndLeftPad("0x0010000001FF", 15, '0');
//		System.out.println(dec2HexAndLeftPad(desString, 12, '0'));
//
//		byte[] bs1 = {97,98,100};
//		bytesToHexFun3(bs1);

		String byteString = "0123456789*!+=|";
		String lightLine = "";
		int dataIndex = 0;
		byte point = 2;
		for (int i = 1; i <= point; i++){
			int count = ((dataIndex + 1) * 2 + 3) * (i - 1);
			lightLine += byteString.substring(count + 2, count + 4) + ":";
			lightLine += byteString.substring(count + 4, count + 6) + "-";
			lightLine += byteString.substring(count + 6, count + 8);
			if ( i < point) {
				lightLine += ";";
			}
		}
		System.out.println(lightLine);
	}

	public static String bytesToHexFun3(byte[] bytes) {
		StringBuilder buf = new StringBuilder(bytes.length * 2);
		for(byte b : bytes) { // 使用String的format方法进行转换
			buf.append(new Integer(b & 0xff));
		}

		return buf.toString();
	}

	public static String hex2DecAndLeftPad(String hex, int length, char padChar){
		String source = hex;
		if(source.startsWith("0x")){
			source = source.substring(2);
		}
		return StringUtils.leftPad(String.valueOf(new BigInteger(source, 16)), length, padChar);
	}

	public static String dec2HexAndLeftPad(String dec, int length, char padChar) {
		String source = dec;
		return StringUtils.leftPad(String.valueOf(Long.toHexString((new BigDecimal(source).longValue()))), length, padChar);
	}
}


