package com.multithreading.examples;

public class DeadlockCreation {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new A(), "Thread-1");
		Thread thread2 = new Thread(new B(), "Thread-2");
		thread1.start();
		thread2.start();
	}

}

/*
 * OUTPUT
 * 
 * Thread-2 has acquired lock on Object class and waiting to acquire lock on
 * String class... Thread-1 has acquired lock on String class and waiting to
 * acquire lock on Object class...
 * 
 */