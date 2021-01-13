package com.edu;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.HMac;

public class Test {
    public static void main(String[] args) {
        String name = "root";
        String pass = "123456";
        HMac hMac = SecureUtil.hmacSha1(pass.getBytes());
        String result = hMac.digestHex(name);
        System.out.println(result);
    }
}
