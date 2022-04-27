package com.example.timetablespring.schedule;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EditNewVehicleToSchedule {

    static void startEdit(DataBaseOfScheduledVehicles dataBaseOfScheduledVehicles) {
        Displays.editVehicleMessage();//print message
        Displays.theNumberOfTheEditedVehicleMessage();//print message
        int editedOfTheNumberVehicle = takingEditedOfTheNumberVehicleFromUser();//taking value to variable from user
        Displays.newDepartureTimeOfTheEditedVehicleMessage();//print message
        String editTime = takingEditDepartureTimeFromUser();//taking value to variable from user
        UserOptions userIsSure = areYouSure();//start function areYouSure
        if(userIsSure == UserOptions.YES){
            editingTheVehicleFromTheSchedule(dataBaseOfScheduledVehicles, editedOfTheNumberVehicle, editTime);//add new vehicle to map
            Displays.theVehicleWasEditedCorrect();// print message
        }
        else if(userIsSure == UserOptions.NO){
            startEdit(dataBaseOfScheduledVehicles);
        }
        else if (userIsSure == UserOptions.BACKTOOPTIONMENU){
            return;
        }
    }

    private static void editingTheVehicleFromTheSchedule(DataBaseOfScheduledVehicles dataBaseOfScheduledVehicles, int editedOfTheNumberVehicle, String editVehicleDepartureTime) {
        dataBaseOfScheduledVehicles.editingTheVehicleFromTheSchedule(editedOfTheNumberVehicle, editVehicleDepartureTime);
    }

    private static int takingEditedOfTheNumberVehicleFromUser() {
        Scanner editedOfTheNumberVehicleScan = new Scanner(System.in);
        while (true) {
            try {
                int editedOfTheNumberVehicle = editedOfTheNumberVehicleScan.nextInt();
                return editedOfTheNumberVehicle;
            } catch (InputMismatchException e) {
                System.out.println("Please enter again vehicle number.");
                editedOfTheNumberVehicleScan.next();
            }
        }
    }

    private static String takingEditDepartureTimeFromUser() {
        Scanner editDepartureTimeScan = new Scanner(System.in);
        while (true) {
            try {
                String editVehicleDepartureTime = editDepartureTimeScan.nextLine();
                return editVehicleDepartureTime;
            } catch (InputMismatchException e) {
                System.out.println("Please choose again game mode.");
                editDepartureTimeScan.next();
            }
        }
    }

    static UserOptions areYouSure() {
        Displays.areYouSureEditMessage();
        Displays.yesOrNoOrBackToOptionMessage();
        Scanner areYouSureScan = new Scanner(System.in);
        int userAnswerToTheQuestionWhetherYouAreSure = 0;
        while (true) {
            try {
                userAnswerToTheQuestionWhetherYouAreSure = areYouSureScan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please choose again option");
                areYouSureScan.next();
            }
            if (userAnswerToTheQuestionWhetherYouAreSure == 1) {
                return UserOptions.YES;
            } else if (userAnswerToTheQuestionWhetherYouAreSure == 2) {
                return UserOptions.NO;
            } else if (userAnswerToTheQuestionWhetherYouAreSure == 3) {
                return UserOptions.BACKTOOPTIONMENU;
            }
        }
    }
}
