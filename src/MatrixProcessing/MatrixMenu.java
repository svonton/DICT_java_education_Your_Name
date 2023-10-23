package MatrixProcessing;

public class MatrixMenu {
    String menuOptionList = """
                1.\tAdd matrices
                2.\tMultiply matrix by a constant
                3.\tMultiply matrices
                4.\tTranspose matrix
                5.\tCalculate a determinant
                0.\tExit""";
    String menuTransposeList = """
            1.\tMain diagonal
            2.\tSide diagonal
            3.\tVertical line
            4.\tHorizontal line""";
    public void matrixMenu(){
        MatrixLogic matrixLogic = new MatrixLogic();
        while (true){
            System.out.println(menuOptionList);
            switch (Integer.parseInt(matrixLogic.userInput())){
                case 1 -> matrixLogic.matrixSum();
                case 2 -> matrixLogic.matrixConstMultiply();
                case 3 -> matrixLogic.matrixMultiply();
                case 4 -> matrixTransposeMenu(matrixLogic);
                case 5 -> matrixLogic.determinantOfMatrix();
                case 0 -> {
                    return;
                }
            }
        }
    }
    private void matrixTransposeMenu(MatrixLogic matrixLogic){
        System.out.println(menuTransposeList);
        switch (Integer.parseInt(matrixLogic.userInput())){
            case 1 -> matrixLogic.transpose();
            case 2 -> matrixLogic.rotate90_flipHorizontal();
            case 3 -> matrixLogic.flipVertical();
            case 4 -> matrixLogic.flipHorizontal();
        }
    }
}
