package com.testinfly.practice;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}

public class LinkList {

	public static void main(String[] args) {
		int num = 10;
		Node node = new Node(1);

		for (int i = 2; i <= num; i++) {
			node = insertFirst(node, i);
		}

		display(node);

	}

	public static void display(Node node) {
		while (node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	public static Node insertFirst(Node node, int data) {
		Node temp = new Node(data);
		temp.next = node;
		return temp;
	}

}
