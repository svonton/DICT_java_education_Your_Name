package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args){
        MachineLogic machineLogic = new MachineLogic();
        Scanner scn = new Scanner(System.in);

        while (!machineLogic.exitStatus){
            machineLogic.updatedMachineAction(scn.nextLine());
        }
    }
}
