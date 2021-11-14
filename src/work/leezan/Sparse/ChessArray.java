package work.leezan.Sparse;

public class ChessArray {
    public static void main(String[] args) {

        //定义原始的二维数组11*11
        //0表示没有棋子，1表示黑子，2表示蓝子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        System.out.println("这个是原始的二维数组");
        for(int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //将二维数组转化为稀疏数组
        //先遍历一下有多少个非0的数字
//        System.out.println(chessArr[0].length);
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0){
                    count++;
                }
            }
        }
        System.out.println(count);
        //创建稀疏数组
        int[][] sparseArr = new int[count + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = count;
        //遍历二维数组，将非0的数放入稀疏数组中
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0){
                    sum++;
                    sparseArr[sum][0] = i;
                    sparseArr[sum][1] = j;
                    sparseArr[sum][2] = chessArr[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println("得到的稀疏数组为");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        //将稀疏数组恢复成二维数组(从第二行开始赋值)
        int[][] chessArr1 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr1[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                System.out.printf("%d\t",chessArr1[i][j]);
            }
            System.out.println();
        }
    }
}
