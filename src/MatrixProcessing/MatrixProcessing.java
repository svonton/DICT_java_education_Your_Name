package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    static Scanner scn;
    public static void main(String[] args){
        scn = new Scanner(System.in);
        MatrixMenu matrixMenu = new MatrixMenu();
        matrixMenu.matrixMenu();
    }
}
