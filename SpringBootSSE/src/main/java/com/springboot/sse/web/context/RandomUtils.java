package com.springboot.sse.web.context;

import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicLong;

public class RandomUtils {
	private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final SecureRandom rnd = new SecureRandom();
	private static final AtomicLong sequenceNumber = new AtomicLong(0);

	public static String randomUniqueString(int length) {

		return sequenceNumber.getAndIncrement() + "___" + randomString(length);
	}

	public static String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
}
