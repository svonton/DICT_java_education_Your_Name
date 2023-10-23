package MatrixProcessing;

public class MatrixMenu {
    String menuOptionList = """
                1.\tAdd matrices
                2.\tMultiply matrix by a constant
                3.\tMultiply matrices
                0.\tExit""";
    public void matrixMenu(){
        MatrixLogic matrixLogic = new MatrixLogic();
        while (true){
            System.out.println(menuOptionList);
            switch (Integer.parseInt(matrixLogic.userInput())){
                case 1 -> matrixLogic.matrixSum();
                case 2 -> matrixLogic.matrixConstMultiply();
                case 3 -> matrixLogic.matrixMultiply();
                case 0 -> {
                    return;
                }
            }
        }
    }
}
