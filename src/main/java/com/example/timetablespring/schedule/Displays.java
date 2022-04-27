package com.example.timetablespring.schedule;

public class Displays {
    static void welcome(){
        System.out.println("Welcome to the schedule system!");
    }
    static void viewOptions(){
        System.out.println("Choose a option.");
        System.out.println("1: Add new vehicle.");
        System.out.println("2: Edit vehicle.");
        System.out.println("3: Remove vehicle.");
        System.out.println("4: View schedule.");
        System.out.println("5: Exit.");
    }
    //Yes or NO or Back to options
    static void yesOrNoOrBackToOptionMessage(){

        System.out.println("1: Yes.");
        System.out.println("2: No.");
        System.out.println("3: Back to options.");
    }

    //Add new vehicle to schedule
    static void addNewVehicleMessage(){
        System.out.println("To add a new one, you need to enter its number and departure time.");
    }
    static void addNumberVehicleMessage(){
        System.out.println("Enter vehice number: ");
    }
    static void addDepartureTimeVehicleMessage(){
        System.out.println("Enter vehicle departure time: ");
    }
    static void areYouSureAddMessage(){
        System.out.println("are you sure you want to add this vehicle?");
    }
    static void newVehicleWasAddCorrectMessage() {
        System.out.println("The new vehicle has been added correctly.");
    }

    //Edit vehicle from schedule
    static void editVehicleMessage(){
        System.out.println("To edit vehicle from schedule, you want to edit and enter a new number and departure time.");
    }
    static void theNumberOfTheEditedVehicleMessage(){
        System.out.println("Enter the number of the edited vehicle: ");
    }
    static void newDepartureTimeOfTheEditedVehicleMessage(){
        System.out.println("Enter a new departure time of the edited vehicle: ");
    }
    static void areYouSureEditMessage(){
        System.out.println("are you sure you want to edit this vehicle?");
    }
    static void theVehicleWasEditedCorrect(){
        System.out.println("The vehicle was edited correct.");
    }

    //Remove vehicle from schedule
    static void removeVehicleFromTheScheduleMessage(){
        System.out.print("To remove a vehicle from the schedule, enter its number and time of the department.");
    }
    static void enterTheVehicleNumberToBeRemovedMessage(){
        System.out.println("Enter the vehicle number to be deleted: ");
    }
    static void areYouSureRemoveMessage(){
        System.out.println("are you sure you want to remove this vehicle?");
    }
    static void theVehicleWasRemoveCorrectMessageMessage(){
        System.out.println("The vehicle was removed correct.");
    }

    //ViewSchedule
    static void viewScheduleHeaderMessage(){
        System.out.println("VEHICLE SCHEDULE");
    }
    static void printSchedule(){
        System.out.println();

    }




}
