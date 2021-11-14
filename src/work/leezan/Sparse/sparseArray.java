package work.leezan.Sparse;

public class sparseArray {
    public static void main(String[] args) {

        //创建一个二维数组
        int[][] chessArr1 = new int[5][5];
        //定义一个数组中的棋子的个数,0代表没有棋子，1代表黑子，2代表白子
        chessArr1[2][4] = 1;
        chessArr1[3][2] = 2;
        chessArr1[1][2] = 1;
        //遍历一下稀疏数组
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                System.out.printf("%d\t",chessArr1[i][j]);
            }
            System.out.println();
        }
        //遍历一下数组中不为0的个数
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0){
                    count++;
                }
            }
        }
        System.out.println("下面是稀疏数组");
        //将二维数组定义到稀疏数组中
        int sum = 0;
        int[][] sparseArr = new int[count + 1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = count;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                    sparseArr[sum][0] = i;
                    sparseArr[sum][1] = j;
                    sparseArr[sum][2] = chessArr1[i][j];
                }
            }
        }


        //遍历一下稀疏数组

        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                System.out.printf("%d\t",sparseArr[i][j]);
            }
            System.out.println();
        }

        //将稀疏数组转为二维数组
        System.out.println("下面是稀疏数组转化为二维数组");
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
                chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];

        }
        for (int i = 0; i < chessArr2.length; i++) {
            for (int j = 0; j < chessArr2[i].length; j++) {
                System.out.printf("%d\t",chessArr2[i][j]);
            }
            System.out.println();
        }
    }
}
