package com.dk.util;

import java.util.UUID;

public class UUIDUtil {

	//����һ��32λ�ַ���
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
