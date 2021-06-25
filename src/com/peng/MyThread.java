package com.peng;
public class MyThread extends Thread {
    //    MainFrame m=new MainFrame();
    MyPanel panel_map;
    boolean running=false;
    float time=200;

    public MyThread(MyPanel panel) {
        panel_map = panel;
    }

    @Override
    public void run(){
        Logic logic = new Logic();
        while (running) {
            logic.nextMap(panel_map);
            panel_map.repaint();	
					try {
						this.sleep((long)time);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        }
    }

    public void stopThead(){
        running=false;
    }

    public void killThread(){
        panel_map.repaint();
    }
}