package com.peng;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LogicTest {
	public static Logic logic = new Logic();
	public static MyPanel panel = new MyPanel();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCenter() {
		panel.length=30;
		panel.width=30;
		panel.map = new int[panel.length][panel.width];
		panel.map[15][16]=1;
		panel.map[15][15]=1;
		panel.map[15][14]=1;
		logic.nextMap(panel);
		for(int i=0;i<panel.length;i++)
			for(int j=0;j<panel.width;j++) {
				if(i==14&&j==15) {
					if(panel.map[i][j]!=1) 
					fail("wrong1");
					}
				else if(i==15&&j==15) {
					if(panel.map[i][j]!=1)
					fail("wrong2");
					}
				else if(i==16&&j==15) {
					if(panel.map[i][j]!=1)
					fail("wrong3");
					}
				else if(panel.map[i][j]==1)
					fail("wrong4");
				else {
					continue;
				}
			}
	}
	
	@Test
	public void testEdge() {
		panel.length=30;
		panel.width=30;
		panel.map = new int[panel.length][panel.width];
		panel.map[0][0]=1;
		panel.map[0][1]=1;
		panel.map[0][2]=1;
		logic.nextMap(panel);
		for(int i=0;i<panel.length;i++)
			for(int j=0;j<panel.width;j++) {
				if(i==0&&j==1) {
					if(panel.map[i][j]!=1)
					fail("wrong1");
					}
				else if(i==1&&j==1) {
					if(panel.map[i][j]!=1)
					fail("wrong2");
					}
				else if(panel.map[i][j]==1) {
					fail("wrong3");
						}
				else {
					continue;
				}
			}
	}
}
