package com.example.timetablespring.schedule;

import java.util.InputMismatchException;
import java.util.Scanner;

class RemoveTheVehicleFromTheSchedule {

    static void startRemove(DataBaseOfScheduledVehicles dataBaseOfScheduledVehicles) {
        Displays.removeVehicleFromTheScheduleMessage();//print message
        Displays.enterTheVehicleNumberToBeRemovedMessage();//print message
        int theVehicleNumberToBeRemoved = takingTheVehicleNumberToBeRemovedFromUser();//taking value to variable from user
        UserOptions userIsSure = areYouSure();//start function areYouSure
        if(userIsSure == UserOptions.YES){
         removedTheVehicleFromTheSchedule(dataBaseOfScheduledVehicles, theVehicleNumberToBeRemoved);//remove vehicle from map
            Displays.theVehicleWasRemoveCorrectMessageMessage();// print message
        }
        else if(userIsSure == UserOptions.NO){
            startRemove(dataBaseOfScheduledVehicles);
        }
        else if (userIsSure == UserOptions.BACKTOOPTIONMENU){
         return;
        }
    }
    private static void removedTheVehicleFromTheSchedule(DataBaseOfScheduledVehicles dataBaseOfScheduledVehicles, int theVehicleNumberToBeRemoved){
        dataBaseOfScheduledVehicles.removedTheVehicleFromTheSchedule(theVehicleNumberToBeRemoved);

    }//remove vehicle from map

    private static int takingTheVehicleNumberToBeRemovedFromUser() {
        Scanner theVehicleNumberToBeRemoveScan = new Scanner(System.in);
        while (true) {
            try {
                int theVehicleNumberToBeRemove = theVehicleNumberToBeRemoveScan.nextInt();
                return theVehicleNumberToBeRemove;
            } catch (InputMismatchException e) {
                System.out.println("Please enter again vehicle number.");
                theVehicleNumberToBeRemoveScan.next();
            }
        }
    }

    private static String takingDepartureTimeToBeRemovedFormUser() {
        Scanner departureTimeToBeRemovedScan = new Scanner(System.in);
        while (true) {
            try {
                String departureTimeToBeRemoved = departureTimeToBeRemovedScan.nextLine();
                return departureTimeToBeRemoved;
            } catch (InputMismatchException e) {
                System.out.println("Please choose again game mode.");
                departureTimeToBeRemovedScan.next();
            }
        }
    }

    static UserOptions areYouSure() {
        Displays.areYouSureRemoveMessage();
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
