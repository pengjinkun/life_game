package com.peng;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyThreadTest {

	public static MyPanel panel =new MyPanel();
	public static  MyThread thread = new MyThread(panel);
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
		thread.running=true;
		thread.time=-1;
		thread.start();
		}
		catch(Exception e) {
			fail("wrong");
		}
	}

}
