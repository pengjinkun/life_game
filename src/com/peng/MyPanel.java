package com.peng;
import javax.swing.*;

import org.junit.Test;

import java.awt.*;

public class MyPanel extends JPanel {

    int length=0;
    int width=0;
    int [][]map;//0为白色，1为黑色
    int size=50;
    int size_x=50;
    int size_y=50;

    
    
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        for(int i=0;i<width;i++)
            for(int j=0;j<length;j++){
                g.drawRect(50+j*size_x,50+i*size_y,size_x,size_y);
            }

        for(int i=0;i<width;i++)
            for(int j=0;j<length;j++){
                if(map[i][j]==1)
                    g.fillRect(50+j*size_x,50+i*size_y,size_x,size_y);
            }

    }
}