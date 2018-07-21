package com.myproject.web.server;

import java.util.Arrays;

public class SystemArrayCopy {
    public static void main(String[] args) {
        int [] ids = {1, 2, 3, 4, 5, 6};
        int [] ids2 = new int[6];
        System.arraycopy(ids, 0, ids2,0, 3);
        System.out.println(Arrays.toString(ids));
        System.out.println(Arrays.toString(ids2));
    }
}
