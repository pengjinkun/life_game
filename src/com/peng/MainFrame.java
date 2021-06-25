package com.peng;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MainFrame extends JFrame {

    public JPanel contentPane;
    public JTextField txt_rows;
    public JTextField txt_colums;
    public JTextField txt_time;
    public JTextField txt_lifeNumber;
    public MyPanel panel_map;
    public float time = 0L;
    public boolean running = true;
    public MyThread thread;
    public boolean status =false;
    public JButton btn_setLife = new JButton("随机生成活细胞");
    public JButton btn_Continue = new JButton("不断演化");
    public JButton bth_begin = new JButton("开始演化");
    public  JButton btn_time = new JButton("确定间隔");
    public JButton btn_Stop = new JButton("停止演化");
    
    public MyPanel getPanel_map() {
        return panel_map;
    }

    public void setPanel_map(MyPanel panel_map) {
        this.panel_map = panel_map;
    }

    /**
     * Create the frame.
     */
    public MainFrame() throws IllegalArgumentException{
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1171, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        panel_map = new MyPanel();
        panel_map.setBounds(10, 10, 900, 750);
        panel.add(panel_map);

        txt_rows = new JTextField();
        txt_rows.setBounds(1027, 36, 66, 21);
        panel.add(txt_rows);
        txt_rows.setColumns(10);

        txt_colums = new JTextField();
        txt_colums.setBounds(1027, 64, 66, 21);
        panel.add(txt_colums);
        txt_colums.setColumns(10);

        JLabel lbl_rows = new JLabel("横列数");
        lbl_rows.setBounds(945, 36, 72, 21);
        panel.add(lbl_rows);

        JLabel lbl_colums = new JLabel("纵列数");
        lbl_colums.setBounds(945, 67, 72, 15);
        panel.add(lbl_colums);

        
        btn_setLife.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                status =false;
                if (thread != null) {
                    thread.stopThead();
                    //thread.killThread();
                }
                Random r = new Random();
                int rows = Integer.parseInt(txt_rows.getText());
             
                int columns = Integer.parseInt(txt_colums.getText());
                panel_map.width = rows;
                panel_map.length = columns;
                panel_map.map = new int[rows][columns];
                panel_map.size_x = 820 / panel_map.length;
                panel_map.size_y = 680 / panel_map.width;
                //int sum = new Integer(txt_lifeNumber.getText());//存活细胞的数量
                int sum = Integer.parseInt(txt_lifeNumber.getText());//存活细胞的数量
                for (int i = 0; i < sum; ) {//随机将sum个点赋值为1，变为活细胞
                    int a1 = r.nextInt(rows);
                    int a2 = r.nextInt(columns);
                    if (panel_map.map[a1][a2] == 1)
                        continue;
                    panel_map.map[a1][a2] = 1;
                    i++;
                }

                panel_map.repaint();
            }
        });

        btn_setLife.setBounds(945, 128, 139, 35);
        panel.add(btn_setLife);

        
        bth_begin.setBounds(964, 176, 97, 40);
        bth_begin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Logic().nextMap(panel_map);
                panel_map.repaint();
            }
        });
        panel.add(bth_begin);

        JLabel lbl_time = new JLabel("演化间隔(s)");
        lbl_time.setBounds(933, 226, 84, 21);
        panel.add(lbl_time);

        txt_time = new JTextField();
        txt_time.setBounds(1033, 226, 66, 21);
        panel.add(txt_time);
        txt_time.setColumns(10);

       
        btn_time.setBounds(967, 283, 105, 34);
        btn_time.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                time = Float.parseFloat(txt_time.getText());
            }
        }) ;
        panel.add(btn_time);

        
        btn_Continue.setBounds(964, 338, 108, 34);
        btn_Continue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws 
            IllegalArgumentException{
                if(status == false){
                thread = new MyThread(panel_map);
                thread.running=true;
                thread.time = time * 1000;
                thread.start();
                status = true;
                }
            }
        });
        panel.add(btn_Continue);

      
        btn_Stop.setBounds(964, 398, 108, 34);
        btn_Stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(thread!=null) {
                status = false;
                thread.stopThead();
            }
            	}
        });
        panel.add(btn_Stop);

        txt_lifeNumber = new JTextField();
        txt_lifeNumber.setBounds(1027, 97, 66, 21);
        panel.add(txt_lifeNumber);
        txt_lifeNumber.setColumns(10);

        JLabel lbl_lifeNumber = new JLabel("活细胞数");
        lbl_lifeNumber.setBounds(945, 103, 72, 15);
        panel.add(lbl_lifeNumber);

        panel_map.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int x = e.getX();
                int y = e.getY();
                int size_x = panel_map.size_x;
                int size_y = panel_map.size_y;
                if (x > 50 && y > 50 && x < 870 && y < 730) {

                    x = (x - 50) / size_x;
                    y = (y - 50) / size_y;
                    if (panel_map.map[y][x] == 0) {
                        panel_map.map[y][x] = 1;
                        panel_map.getGraphics().fillRect(50 + x * size_x,50 + y * size_y , size_x, size_y);
                    } else {
                        panel_map.map[y][x]=0;
                        panel_map.getGraphics().clearRect(50 + x * size_x, 50 + y * size_y, size_x, size_y);
                    }
                }

                for(int i=0;i<panel_map.width;i++)
                    for(int j=0;j<panel_map.length;j++){
                        panel_map.getGraphics().drawRect(50+j*size_x,50+i*size_y,size_x,size_y);
                    }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

}