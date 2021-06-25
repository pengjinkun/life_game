package com.peng;

public class Logic {
    int width = 0;
    int length = 0;
    int[][] map;

    public void nextMap(MyPanel d) {
        map = d.map;
        length = d.length;
        width = d.width;
        int[][] newMap = new int[width][length];
        for (int i = 0; i < width; i++)
            for (int j = 0; j < length; j++)
                newMap[i][j] = 0;
        reSetMap(newMap);
        d.map = newMap;

    }

    public void reSetMap(int[][] newMap) {
        int around = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {

                for (int m = i - 1; m <= i + 1; m++)
                    for (int n = j - 1; n <= j + 1; n++) {

                        if ((m == i && n == j))
                            continue;
                        if (m >= 0 && n >= 0 && m < width && n < length) {
                            if (map[m][n] == 1)
                                around++;
                            if(around>3)
                            	break;
                        }

                    }

                if (around > 3)
                    newMap[i][j] = 0;
                else if (around <= 1)
                    newMap[i][j] = 0;
                else if (around == 3)
                    newMap[i][j] = 1;
                else {
                    newMap[i][j] = map[i][j];
                }
                around = 0;
            }

        }
    }
}
