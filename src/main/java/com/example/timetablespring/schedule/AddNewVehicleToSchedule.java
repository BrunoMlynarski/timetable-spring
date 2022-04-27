package com.example.timetablespring.schedule;

import java.util.InputMismatchException;
import java.util.Scanner;

class AddNewVehicleToSchedule {

    static void startAdd(DataBaseOfScheduledVehicles dataBaseOfScheduledVehicles){
        Displays.addNewVehicleMessage();//print message
        Displays.addNumberVehicleMessage();//print message
        int number = takingNumberToNewVehicleFormUser();//taking value to variable from user
        Displays.addDepartureTimeVehicleMessage();//print message
        String time = takingDepartureTimeToNewVehicleFormUser();//taking value to variable from user
        UserOptions userIsSure = areYouSure();//start function areYouSure
        if(userIsSure == UserOptions.YES){
            addNewVehicleToSchedule(dataBaseOfScheduledVehicles,number, time);//add new vehicle to map
            Displays.newVehicleWasAddCorrectMessage();// print message
        }
        else if(userIsSure == UserOptions.NO){
            startAdd(dataBaseOfScheduledVehicles);
        }
        else if (userIsSure == UserOptions.BACKTOOPTIONMENU){
            return;

        }
    }

    private static void addNewVehicleToSchedule(DataBaseOfScheduledVehicles dataBaseOfScheduledVehicles, int vehicleNumber, String vehicleDepartureTime){
        dataBaseOfScheduledVehicles.addNewVehicleToSchedule(vehicleNumber, vehicleDepartureTime);
    }
      private static int takingNumberToNewVehicleFormUser(){
         Scanner numberToNewVehicleScan = new Scanner(System.in);
         while (true) {
             try {
                 int vehicleNumberToNewVehicle = numberToNewVehicleScan.nextInt();
                 return vehicleNumberToNewVehicle;
             } catch (InputMismatchException e) {
                 System.out.println("Please enter again vehicle number.");
                 numberToNewVehicleScan.next();
             }
         }
     }
     private static String takingDepartureTimeToNewVehicleFormUser(){
        Scanner departureTimeToNewVehicleScan = new Scanner(System.in);
        while (true) {
            try {
                String vehicleDepartureTimeToNewVehicle = departureTimeToNewVehicleScan.nextLine();
                return vehicleDepartureTimeToNewVehicle;
            } catch (InputMismatchException e) {
                System.out.println("Please choose again game mode.");
                departureTimeToNewVehicleScan.next();
            }
        }
    }
    static UserOptions areYouSure() {
        Displays.areYouSureAddMessage();
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
