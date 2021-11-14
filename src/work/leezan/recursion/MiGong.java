package work.leezan.recursion;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][8];
        for (int i = 0; i < 8; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][7] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;
        System.out.println("前面的图形");
        //前面的图形
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
//            System.out.print("map[" + i + "][" + j + "]");
                System.out.print(map[i][j] + "   ");
            }
            System.out.println();
        }
        setMap(map,1, 1);
        System.out.println("走后的图形");
        //走后的图形
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
//              System.out.print("map[" + i + "][" + j + "]");
                System.out.print(map[i][j] + "   ");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路
    //说明
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发 (1,1)
    //3. 如果小球能到 map[6][5] 位置，则说明通路找到.
    //4. 约定： 当map[i][j] 为 0 表示该点没有走过当为1表示墙,2表示通路可以走,3表示该点已经走过，但是走不通
    //5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯
    /**
     *
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setMap(int[][] map, int i, int j) {
        if (map[6][6] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setMap(map,i + 1, j)) {
                    return true;
                } else if (setMap(map, i, j + 1)) {
                    return true;
                } else if (setMap(map, i - 1, j)) {
                    return true;
                } else if (setMap(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
