package com.multithreading.examples;

class B extends Thread {
	public void run() {

		synchronized (Object.class) {
			System.out.println(Thread.currentThread().getName() + " has acquired "
					+ "lock on Object class and waiting to acquire lock on String class...");

			/*
			 * Adding this optional delay so that Thread-1 could enough time to
			 * lock String class and form deadlock. If you remove this sleep,
			 * because of threads unpredictable behavior it might that Thread-2
			 * gets completed even before Thread-1 is started and we will never
			 * form deadLock.
			 */
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (String.class) {
				System.out.println(Thread.currentThread().getName() + " has acquired lock on String class");
			}
		}

		System.out.println(Thread.currentThread().getName() + " has ENDED");
	}
}