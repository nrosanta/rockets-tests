package com.testinfly.practice;

import java.util.ArrayList;

class Machine {

	public void start() {
		System.out.println("Machine starting.");
	}
	
	@Override
	public String toString() {
		return "This is a machine.";
	}

}

class Camera extends Machine {
	
	public void takePictue() {
		System.out.println("Take Picture");
	}
	
	@Override
	public String toString() {
		return "This is a camera.";
	}
}

public class GenericsWildCardsBounds {

	public static void main(String[] args) {
		ArrayList<Machine> list = new ArrayList<>();
		list.add(new Machine());
		list.add(new Machine());
		
		display(list);
		
		ArrayList<Camera> list2 = new ArrayList<>();
		list2.add(new Camera());
		list2.add(new Camera());
		
		display(list2);
		display2(list2);
		
		display3("#3: "+list);
		display3("#4: "+list2);

	}
	
	public static void display(ArrayList<? extends Machine> list) {
		for(Machine m: list ) {
			System.out.println(m.toString());
			m.start();
			
		}
	}
	
	public static void display2(ArrayList<? super Camera> list) {
		for(Object m: list ) {
			System.out.println(m.toString());
			
		}
	}
	
	//Generic method example
	public static <T> void display3(T list) {
		System.out.println(list.toString());
	}

}
