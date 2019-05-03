package com.testinfly.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		String filePath = "/Users/admin/eclipse-workspace/rockets-tests/src/test/resources/test.csv";
		//readFile(filePath);
		
		int[] arr1 = {1,2,3,3,4,5,5,6,7,7,8,9};
		System.out.println(Arrays.toString(removeDup1(arr1)));

	}
	
	public static void readFile(String fileName) throws IOException {
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		while(br.readLine() != null) {
			System.out.println(br.readLine().toUpperCase());
		}
		
		br.close();
	}
	
	public static int[] removeDup(int[] arr){
		int j=0;
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]!=arr[i+1]){
				arr[j++]=arr[i];
			}
		}
		arr[j++]=arr[arr.length-1];
		System.out.println(Arrays.toString(arr));
		return Arrays.copyOfRange(arr,0,j);
	}

	public static int[] removeDup1(int[] arr) {
		int j=0;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]!=arr[i+1])
				arr[j++] = arr[i];
		}
		
		arr[j++] = arr[arr.length-1];
		return Arrays.copyOfRange(arr, 0, j);
	}
}
