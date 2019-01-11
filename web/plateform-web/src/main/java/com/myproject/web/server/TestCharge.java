package com.myproject.web.server;

public class TestCharge {
	public static void chargeFee( int charge){

		byte[] data = new byte[9];
		int index = 0;


		// 数据包类型
		data[index++] = 0x04;
		;
		// 电费 Ddata
		data[index++] = (byte) (charge & 0xff); // 低字节
		data[index++] = (byte) (charge >> 8 & 0xff); // 高字节
		data[index++] = (byte) (charge >> 16 & 0xff);
		data[index] = (byte) (charge >> 24 & 0xff);
	}

	public static void main(String[] args) {
		chargeFee(563001);
	}
}
