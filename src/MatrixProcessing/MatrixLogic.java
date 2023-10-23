package MatrixProcessing;

import java.util.Scanner;
public class MatrixLogic {
    private Scanner scn = new Scanner(System.in);

    public void matrixSum(){
        int[][] matrix1= userMatrix();
        int[][] matrix2=userMatrix();
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("matrix size not equal");
            return;
        }
        int[][] matrixSum = new int[matrix1.length][matrix1[0].length];

        for (int i =0; i<matrix1.length;i++){
            for (int j =0; j<matrix1[0].length;j++){
                matrixSum[i][j] = matrix1[i][j]+matrix2[i][j];
            }
        }
        matrixPrint(matrixSum);
    }
    public void matrixConstMultiply(){
        int[][] matrix1=userMatrix();
        System.out.println("input constant");
        int userConst = Integer.parseInt(userInput());
        int[][] matrixConstMultiply = new int[matrix1.length][matrix1[0].length];

        for (int i =0; i<matrix1.length;i++){
            for (int j =0; j<matrix1[0].length;j++){
                matrixConstMultiply[i][j] = matrix1[i][j]*userConst;
            }
        }
        matrixPrint(matrixConstMultiply);
    }
    private void matrixPrint(int[][] matrix){
        System.out.println("The result matrix is: ");
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }
    private int[][] userMatrix(){
        System.out.println("input matrix size MxN");
        String[] matrixSize = userInput().split(" ");
        int[][] matrix = new int[Integer.parseInt(matrixSize[0])][Integer.parseInt(matrixSize[1])];
        System.out.println("input matrix rows values");
        for (int i =0; i<matrix.length;i++){
            String[] row = userInput().split(" ");
            for (int j=0; j<row.length;j++){
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        return matrix;
    }
    private String userInput(){
        System.out.print(">>> ");
        return scn.nextLine();
    }
}
