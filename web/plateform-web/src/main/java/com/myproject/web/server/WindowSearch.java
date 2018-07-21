package com.myproject.web.server;

import com.sun.java.swing.plaf.windows.WindowsMenuUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowSearch {
    public static void main(String[] args) {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("Search SensorCode");
        // Setting the width and height of frame
        frame.setSize(700, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建 JLabel
        JLabel sensorCodeLabel = new JLabel("设备编号:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        sensorCodeLabel.setBounds(200,150,100,40);
        panel.add(sensorCodeLabel);

        /*
         * 创建文本域用于用户输入
         */
        JTextField sensorCodeText = new JTextField(20);
        sensorCodeText.setBounds(300,150,200,40);
        panel.add(sensorCodeText);

        String value = sensorCodeText.getText().trim();

        JLabel sensorIDLabel = new JLabel("设备ID:");
        sensorIDLabel.setBounds(200,200,80,25);

        panel.add(sensorIDLabel);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        JTextField sensorIDText = new JTextField(20);
        sensorIDText.setBounds(300,200,200,40);
        sensorIDText.setEditable(false);
        panel.add(sensorIDText);

        // 创建登录按钮
        JButton loginButton = new JButton("查询");
        loginButton.setBounds(300, 260, 100, 35);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(loginButton);
    }

    private static String querySensorId(String sensorCode){
        String sensorId = "";
        return sensorId;
    }
}

