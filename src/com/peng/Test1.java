package com.peng;
import java.util.ArrayList;
import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        while (true){
        new Test1().method();
        new Test1().method1();
        }
    }

    public  void method(){
        long time1= System.currentTimeMillis();
        MyPanel panel_map = new MyPanel();
        Random r = new Random();
        int rows = 100;
        int columns = 100;
        panel_map.width = rows;
        panel_map.length = columns;
        panel_map.map = new int[rows][columns];
        int sum = 3000;//存活细胞的数量
        for (int i = 0; i < sum; ) {//随机将sum个点赋值为1，变为活细胞
            int a1 = r.nextInt(rows);
            int a2 = r.nextInt(columns);
            if (panel_map.map[a1][a2] == 1)
                continue;
            panel_map.map[a1][a2] = 1;
            i++;
        }
        long time2= System.currentTimeMillis();
        System.out.print(time2-time1+"  ");
    }

    
    
    public  void  method1(){
        long time1= System.currentTimeMillis();
        MyPanel panel_map = new MyPanel();
        Random r=new Random();
        panel_map.length=100;
        panel_map.width=100;
        panel_map.map = new int[1000][1000];
        ArrayList<Integer> nums1=new ArrayList<Integer>();
        for(int i=0;i<10000;i++){
            nums1.add(i);
        }
        for(int i=0;i<3000;i++){
            int x=r.nextInt(nums1.size()-1);
            nums1.remove(x);
            int m= nums1.get(x)/100;
            int n= nums1.get(x)%100;
            panel_map.map[m][n]=1;
        }
        long time2= System.currentTimeMillis();
        System.out.println(time2-time1);
    }
    
    
    public  void method3(){
        long time1= System.currentTimeMillis();
        MyPanel panel_map = new MyPanel();
        Random r = new Random();
        int rows = 1000;
        int columns = 1000;
        panel_map.width = rows;
        panel_map.length = columns;
        panel_map.map = new int[rows][columns];
        int sum = 300000;//存活细胞的数量
        for (int i = 0; i < sum; ) {//随机将sum个点赋值为1，变为活细胞
            int a1 = r.nextInt(rows);
            int a2 = r.nextInt(columns);
            if (panel_map.map[a1][a2] == 1)
                continue;
            panel_map.map[a1][a2] = 1;
            i++;
        }

        long time2= System.currentTimeMillis();
        System.out.print(time2-time1+"  ");
    }
    
    public  void  method4(){
        long time1= System.currentTimeMillis();
        MyPanel panel_map = new MyPanel();
        Random r=new Random();
        panel_map.length=1000;
        panel_map.width=1000;
        panel_map.map = new int[1000][1000];
        ArrayList<Integer> nums1=new ArrayList<Integer>();
        for(int i=0;i<1000000;i++){
            nums1.add(i);
        }
        for(int i=0;i<300000;i++){
            int x=r.nextInt(nums1.size()-1);
            nums1.remove(x);
            int m= nums1.get(x)/1000;
            int n= nums1.get(x)%1000;
            panel_map.map[m][n]=1;
        }
        long time2= System.currentTimeMillis();
        System.out.println(time2-time1);
    }
    
}
