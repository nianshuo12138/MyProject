package com.dk.util;

import java.util.UUID;

public class UUIDUtil {

	//返回一个32位字符串
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
