package com.myproject.web.server;

public class StringReplace {
    public static void main(String[] args) {
        String str="abcmdf";
        //获取指定字符位置 例如取 替换c字符
        int i=str.indexOf("c");
        //str.charAt(i) 取出指定字符(char类型 无法直接转string) String.valueOf 转换成string类型
        String str2=String.valueOf(str.charAt(i));
        //X为指定替换字符
        str=str.replaceFirst(str2,"X");
        System.out.println(str);

        byte hexData = (byte) 0x3c & 0xff;
        String byteData = Integer.toBinaryString(hexData);
        String stringData =  String.format("%08d", Integer.parseInt(Integer.toBinaryString(hexData)));
        System.out.println(stringData);
        String changeData = stringData.substring(0, 3) + "0" + stringData.substring(4, 8);
        System.out.println("modelHexData:" + changeData);
        byte modelHexData = (byte) (Integer.parseInt(changeData, 16) & 0xff);
        System.out.println(modelHexData);
    }
}
