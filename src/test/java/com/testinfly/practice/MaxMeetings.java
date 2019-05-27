package com.testinfly.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Meeting{
	String name;
	int duration;
	
	Meeting(String name, int duration){
		this.name = name;
		this.duration = duration;
	}
}
public class MaxMeetings {

	public static void main(String[] args) {
		List<Meeting> list  = new ArrayList<>();
		list.add(new Meeting("One",4));
		list.add(new Meeting("Two",2));
		list.add(new Meeting("Three",3));
		list.add(new Meeting("Four",2));
		list.add(new Meeting("Four",1));
		
		printMeetings(getMaxMeetings(list));
		
	}
	
	public static void printMeetings(List<Meeting> list) {
		for(Meeting x : list) {
			System.out.println(x.name+"->"+x.duration);
		}
	}
	
	
	
	public static List<Meeting> getMaxMeetings(List<Meeting> list){
		List<Meeting> res = new ArrayList<>();
		Queue<Meeting> heap = new PriorityQueue<>((n1,n2)->n1.duration-n2.duration);
		
		int total = 0;
		for(Meeting x : list)
			heap.add(x);
		
		while(!heap.isEmpty()) {
			if(total+heap.peek().duration<=8) {
				total += heap.peek().duration;
				res.add(heap.poll());
			}
			else 
				return res;
		}
		
		return res;
	}
}
