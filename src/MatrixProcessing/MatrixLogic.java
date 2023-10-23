package MatrixProcessing;

public class MatrixLogic {

    void matrixSum(){
        int[][] matrix1=userMatrix();
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
    void matrixConstMultiply(){
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
    void matrixMultiply() {
        int[][] matrix1=userMatrix();
        int[][] matrix2=userMatrix();
        if (matrix2[0].length != matrix1.length) {
            System.out.println("matrix size not equal");
            return;
        }
        int matrixMulti[][] = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++)
                    matrixMulti[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
        matrixPrint(matrixMulti);
    }
    void flipVertical() {
        int[][] matrix1=userMatrix();
        int size = matrix1.length;
        for (int i=0; i<size; i++) {
            for (int j=0; j<size/2; j++) {
                int tmp = matrix1[i][size-1-j];
                matrix1[i][size-1-j] = matrix1[i][j];
                matrix1[i][j] = tmp;
            }
        }
        matrixPrint(matrix1);
    }
    void flipHorizontal() {
        int[][] matrix1=userMatrix();
        int size = matrix1.length;
        for (int i=0; i<size/2; i++) {
            for (int j=0; j<size; j++) {
                int tmp = matrix1[size-1-i][j];
                matrix1[size-1-i][j] = matrix1[i][j];
                matrix1[i][j] = tmp;
            }
        }
        matrixPrint(matrix1);
    }
    void transpose() {
        int[][] matrix1=userMatrix();
        int size = matrix1.length;
        for (int i=0; i<size-1; i++) {
            for (int j=i+1; j<size; j++) {
                int tmp = matrix1[i][j];
                matrix1[i][j] = matrix1[j][i];
                matrix1[j][i] = tmp;
            }
        }
        matrixPrint(matrix1);
    }
    void rotate90_flipHorizontal() {
        int[][] matrix1=userMatrix();
        int size = matrix1.length;
        int[][] temp = new int[size][size];

        for (int i=0;i<size;i++)
            for (int j=0;j<size;j++)
                temp[i][j] = matrix1[size-1-j][i];

        matrix1 = temp;
        for (int i=0; i<size/2; i++) {
            for (int j=0; j<size; j++) {
                int tmp = matrix1[size-1-i][j];
                matrix1[size-1-i][j] = matrix1[i][j];
                matrix1[i][j] = tmp;
            }
        }
        matrixPrint(matrix1);
    }
    void determinantOfMatrix() {
        int[][] mat=userMatrix();
        int n = mat.length;
        int det = MatrixInverse.determinant(mat,n);
        System.out.println(String.format("""
                The result is:
                %d""",det)); // Det(kA)/k=Det(A);
    }

    void inverseMatrix(){
        int[][] mat=userMatrix();
        int n = mat.length;
        MatrixInverse.inverseOfMatrix(mat,n);
    }
    private void matrixPrint(int[][] matrix){
        System.out.println("The result matrix is: ");
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private int[][] userMatrix(){
        System.out.println("input matrix size ROWSxCOLUMNS");
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
    String userInput(){
        System.out.print(">>> ");
        return MatrixProcessing.scn.nextLine();
    }
}
