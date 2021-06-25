package com.peng;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


import java.awt.AWTException;
import java.awt.Robot;


public class MainFrameTest {
    public static MainFrame frame = new MainFrame();
	@Before
	public void setUp() throws Exception {
		frame.setVisible(true);
		frame.txt_rows.setText("50");
		frame.txt_colums.setText("50");
		frame.txt_lifeNumber.setText("1");
		frame.btn_setLife.doClick();
	}

	//不输入数字
	@Test(timeout=1000)
	public void test() {
		try {
		frame.txt_lifeNumber.setText("");
		frame.btn_setLife.doClick();
		} catch (Exception e) {
			//e.printStackTrace();
			fail("wrong");
			System.out.println("test "+false);
		}
		System.out.println("test "+true);
	}
	//输入负数
	@Test(timeout=1000)
	public void test2() {
		try {
		frame.txt_lifeNumber.setText("-500");
		frame.btn_setLife.doClick();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("test2 "+false);
			fail("wrong");
			
		}
		System.out.println("test2 "+true);
	}

	//输入非数字
	@Test(timeout=1000)
	public void test1() {
		try {
		frame.txt_lifeNumber.setText("i");
		frame.btn_setLife.doClick();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("test1 "+false);
			fail("wrong");
			
		}
		System.out.println("test1 "+true);
	}
	
	//输入小数
	@Test(timeout=1000)
	public void test3() {
		try {
		frame.txt_lifeNumber.setText("500.2");
		frame.btn_setLife.doClick();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("test3 "+false);
			fail("wrong");
			
		}
		System.out.println("test3 "+true);
	} 
	
	//活细胞数多于网格数
		@Test
		public void test4() {
			try {
			frame.txt_lifeNumber.setText("2501");
			frame.btn_setLife.doClick();
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("test3 "+false);
				fail("wrong");
				
			}
			System.out.println("test3 "+true);
		}
//	@Test
//	public void test4() {
//		try {
//		frame.txt_time.setText("-1");
//		frame.btn_time.doClick();
//		frame.btn_Continue.doClick();}
//		catch (Exception e) {
//			//e.printStackTrace();
//			System.out.println("test4 "+false);
//			fail("wrong");
//			
//		}
//		System.out.println("test4 "+true);
//	}
//	
//	@Test(timeout=1000)
//	public void test5() {
//		try {
//		frame.txt_time.setText("j");
//		frame.btn_time.doClick();
//		frame.btn_Continue.doClick();
//		} catch (Exception e) {
//			//e.printStackTrace();
//			System.out.println("test5 "+false);
//			fail("wrong");
//			
//		}
//		System.out.println("test5 "+true);
//	}
	
}
