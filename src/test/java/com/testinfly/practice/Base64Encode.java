package com.testinfly.practice;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Encode {

	public static void main(String[] args) {
		System.out.println(encode64("Ross:Meitei"));

	}
	
	public static String encode64(String str){
		byte[] msg = str.getBytes(StandardCharsets.UTF_8);
		str = Base64.getEncoder().encodeToString(msg);
		return str;
	}

}
