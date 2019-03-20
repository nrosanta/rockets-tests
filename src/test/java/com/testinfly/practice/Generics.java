package com.testinfly.practice;

class Test<T> {
	T obj;

	Test(T obj) {
		this.obj = obj;
	}

	public T getObject() {
		return this.obj;
	}
}

public class Generics {

	public static void main(String[] args) {
		Test<Integer> iObj = new Test<>(15);
		System.out.println(iObj.getObject());

		Test<String> sObj = new Test<>("This is a string data type");
		System.out.println(sObj.getObject());

	}

}
