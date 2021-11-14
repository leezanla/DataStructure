package work.leezan.recursion;

public class MiGong2 {
    public static void main(String[] args) {
        int[][] map = new int[8][10];
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][9] = 1;
        }
        for (int i = 0; i < 10; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        map[4][1] = 1;
        map[4][2] = 1;
        map[4][3] = 1;
        System.out.println("设置好的地图");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
        setMap(map, 1, 1);
        System.out.println("走后的地图");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }
    private static boolean setMap(int[][] map,int n,int m) {
        if (map[6][8] == 2) {
            return true;
        } else {
            if (map[n][m] == 0) {
                map[n][m] = 2;
                if (setMap(map,n + 1,m)) {
                    return true;
                } else if (setMap(map, n, m + 1)) {
                    return true;
                } else if (setMap(map,n - 1,m)) {
                    return true;
                } else if ((setMap(map, n, m - 1))) {
                    return true;
                } else {
                    map[n][m] = 3;
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }
    private void printMap(){

    }
}
