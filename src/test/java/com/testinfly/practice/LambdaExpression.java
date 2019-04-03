package com.testinfly.practice;
/**
 * 
 * https://caveofprogramming.com/java/whats-new-in-java-8-lambda-expressions.html
 *
 */
interface Executable {
	void execute();
}

class Runner {
	public void run(Executable e) {
		e.execute();
	}
}

public class LambdaExpression {
	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.run(new Executable() {
			public void execute() {
				System.out.println("Hello");
				System.out.println("There");
				
			}
		});

		runner.run(() -> System.out.println("Hi"));

	}
}
