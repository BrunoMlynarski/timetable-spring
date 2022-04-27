package com.example.timetablespring.schedule;
class MainMenu {
     void startMain(DataBaseOfScheduledVehicles database){
          //Displays.welcome();// display a welcome inscription
          UserOptions selectedOption = MetodsProgram.collectionAndChoosenUserOption();//collection and choosing user option
          if(selectedOption == UserOptions.ADD){
               AddNewVehicleToSchedule.startAdd(database);
          }
          else if(selectedOption == UserOptions.EDIT){
               EditNewVehicleToSchedule.startEdit(database);
          }
          else if(selectedOption == UserOptions.REMOVE){
               RemoveTheVehicleFromTheSchedule.startRemove(database);
          }
          else if(selectedOption == UserOptions.VIEW){
               database.printSchedule();
          }
          else if(selectedOption == UserOptions.CLOSE){
               System.out.println("Thank you for using the program, have a nice day!");
               exitProgram();
          }
     }

     boolean exitProgram(){
          return false;
     }
}
