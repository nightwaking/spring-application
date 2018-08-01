package com.myproject.web.server;

import java.util.Date;

public class JavaThread {
    /**
     * java 多线程实战
     * 进程是程序的运行实例。运行一个java程序的实质是启动一个Java虚拟机进程，一个运行的Java程序就是一个java
     * 虚拟机的进程。
     * java web例外。一个java web服务器是一个进程，可以同时运行多个java web应用
     * 进程是程序向操作系统申请资源的基本单位。线程是进程中可独立执行的最小单位。
     * 一个进程可以包含多个线程。同一个进程中的所有线程共享该进程中的资源，内存空间，文件句柄。
     * 线程所要完成的计算被称为任务，特定的线程总是在执行特定的任务。任务代表线程索要完成的工作。
     */
    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println(new Date());
            Thread.sleep(1000);
        }
    }

    /**
     * java平台上的一个线程就是一个java对象。 增加线程可能会增加单位时间内的任务量,提高程序的计算效率。
     * 但也有可能降低程序的计算效率
     *
     * 多线程的应用例子
     * 音乐播放手机软件在启动时会启动一个线程用于在用户的手机存储中查找音乐文件，然后将这些文件名添加
     * 到特定播放列表，查找文件是相对较慢的操作。会出现明显的卡顿。所以将搜索本地文件的任务使用专门的一个线程
     * 来执行。
     */
}
