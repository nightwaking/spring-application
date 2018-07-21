package com.myproject.web.server;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.alex.commons.biz.OperateContext;
import com.alex.commons.jpa.POperateInfo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        String json = "{\"username\":\"zhangsan\",\"性别\":\"男\",\"company\":{\"companyName\":\"中华\",\"address\":\"北京\"},\"cars\":[\"奔驰\",\"宝马\"]}";
        ObjectMapper mapper = new ObjectMapper();
        //JSON ----> JsonNode
        JsonNode rootNode = mapper.readTree(json);
        Iterator<String> keys = rootNode.fieldNames();
        while(keys.hasNext()){
            String fieldName = keys.next();
            System.out.println(fieldName + ": " + rootNode.path(fieldName).toString());
        }

        byte[] data = new byte[] {112, 52, 53};
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            String hex = Integer.toHexString(data[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex ;
            }
            result.append(hex.toUpperCase());
        }
        System.out.println(result.toString());
        //JsonNode ----> JSON
        System.out.println(rootNode.toString());
        System.out.println(mapper.writeValueAsString(rootNode).toString());

        List<String> testList = new ArrayList<String>();
        List<List<String>> arrList = new ArrayList<List<String>>();
        testList.add("test");
        arrList.add(testList);
        System.out.println(testList);
        arrList.toArray();
        System.out.println(arrList);

        String stringData = "12D323D";
        String [] inData = new String[4];

        for (int i = 0 ; i < inData.length; i++) {
            inData[i] = String.valueOf(stringData.charAt(i));
        }

        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = stringData.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            // sb.append(' ');
        }

        char[] hexs = stringData.toCharArray();
        String a="";
        for (char c : hexs) {
            switch (c) {
                case '0':
                    a+="0,";
                    break;
                case '1':
                    a+="1,";
                    break;
                case '2':
                    a+="2,";
                    break;
                case '3':
                    a+="3,";
                    break;
                case '4':
                    a+="4,";
                    break;
                case '5':
                    a+="5,";
                    break;
                case '6':
                    a+="6,";
                    break;
                case '7':
                    a+="7,";
                    break;
                case '8':
                    a+="8,";
                    break;
                case '9':
                    a+="9,";
                    break;
                case 'A':
                    a+="10,";
                    break;
                case 'B':
                    a+="11,";
                    break;
                case 'C':
                    a+="12,";
                    break;
                case 'D':
                    a+="13,";
                    break;
                case 'E':
                    a+="14,";
                    break;
                case 'F':
                    a+="15,";
                    break;
            }
        }
        String[] b=a.split(",");
        int c=1;
        int e=c;

        boolean booleanData = wrapData(bs)[1] == 0x3c;
        System.out.println(booleanData);

        System.out.println(0x05 | 0x0f);

        System.out.println((byte)(c & 0xff) == 0x01);
        System.out.println(OperateContext.getDefault().getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));
        String testData = "12 D3 34";
        getHexDateBytes(testData);
        int index = 0;
        int [] testInt = new int[] {1, 2, 3, 4};
        int [] newInt = new int[7];
        int [] hexInt = new int[]{5, 6, 7, 8, 9};

        System.arraycopy(testInt, 0, newInt, 0, testInt.length);
        index += testInt.length;

        System.out.println(index);

        for (int i = 3; i < hexInt.length; i++){
            newInt[index++] = hexInt[i];
        }

        for (int i = 0; i < 7; i++){
            System.out.println(newInt[i]);
        }

        SimpleDateFormat newData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(newData.format(new Date()));


        System.out.println(new POperateInfo(OperateContext.getDefault()).getOperateTime().toString());

    }

    private static byte[] wrapData(byte[] data) {
        assert data != null;

        int dataLength = data.length;
        byte[] result = new byte[dataLength + 14];

        int index = 0;
        // 起始标识
        result[index++] = 0x3c;
        result[index++] = 0x3c;
        result[index++] = 0x3c;
        result[index++] = 0x5a;
        // 帧控制字
        result[index++] = 0x20;
        result[index++] = 0x00;
        // 数据长度
        result[index++] = (byte) ((dataLength + 2) & 0x00ff); // 增加2个mid的长度，低位
        result[index++] = (byte) ((dataLength + 2) >> 8 & 0x00ff); // 增加2个mid的长度，高位

        // mid数据
        byte[] midDatas = new byte[]{0x00, 0x00}; // mid默认为0

        // 数据,需要加密
        System.arraycopy(data, 0, result, index, dataLength);
        index = index + dataLength;

        // mid，需要加密
        System.arraycopy(midDatas, 0, result, index, midDatas.length);
        index = index + midDatas.length;

        // 秘钥
        result[index++] = 0x00; // 由于mid会在插件中更新，因此暂不加密

        // crc，由于mid会在插件中更新，因此暂不计算crc，crc默认为00 00
        result[index++] = (byte) 0x00; // 低字节
        result[index++] = (byte) 0x00; // 高字节

        // 结束标志
        result[index] = (byte) 0xed;

        return result;
    }

    private  static byte[] getHexDateBytes(String dataHex) {
        String[] hexArray = dataHex.split(" ");
        byte[] data = new byte[hexArray.length];
        for (int i = 0; i < data.length; i++){
            data[i] = (byte) (Integer.valueOf(hexArray[i], 16) & 0xff);
            System.out.println(data[i]);
        }
        return data;
    }

}
