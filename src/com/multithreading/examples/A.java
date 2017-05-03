package com.multithreading.examples;

class A implements Runnable {
	public void run() {

		synchronized (String.class) {

			/*
			 * Adding this optional delay so that Thread-2 could enough time to
			 * lock Object class and form deadlock. If you remove this sleep,
			 * because of threads unpredictable behavior it might that Thread-1
			 * gets completed even before Thread-2 is started and we will never
			 * form deadLock.
			 */
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + "has acquired lock "
					+ "on String class and waiting to acquire lock on Object class...");
			synchronized (Object.class) {
				System.out.println(Thread.currentThread().getName() + " has acquired lock on Object class");
			}
		}

		System.out.println(Thread.currentThread().getName() + " has ENDED");
	}
}
