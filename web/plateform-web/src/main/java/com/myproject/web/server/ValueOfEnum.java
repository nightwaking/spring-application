package com.myproject.web.server;

public class ValueOfEnum {
    public static void main(String[] args) {
        System.out.println("输出结果:" + SensorModel.valueOf("plastic"));
    }
}

enum SensorModel {
    // 电信铝外壳产品
    aluminium,
    plastic
}
