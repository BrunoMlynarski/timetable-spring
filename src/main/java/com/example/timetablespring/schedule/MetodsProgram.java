package com.example.timetablespring.schedule;

import java.util.InputMismatchException;
import java.util.Scanner;

class MetodsProgram {
    static UserOptions collectionAndChoosenUserOption() {
        Scanner userOptionScan = new Scanner(System.in);
        Displays.viewOptions();
        int choosenUserOption = 0;
        while (true) {
            try {
                choosenUserOption = userOptionScan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please choose again option");
                userOptionScan.next();
            }
            if (choosenUserOption == 1) {
                return UserOptions.ADD;
            }
            else if (choosenUserOption == 2) {
                return UserOptions.EDIT;
            }
            else if (choosenUserOption == 3) {
                return UserOptions.REMOVE;
            }
            else if (choosenUserOption == 4) {
                return UserOptions.VIEW;
            }
            else if (choosenUserOption == 5){
                return UserOptions.CLOSE;
            }
        }
    }
}
