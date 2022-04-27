package com.example.timetablespring.schedule;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
class DataBaseOfScheduledVehicles {
    TimeEntryRepository repository;

    public void addNewVehicleToSchedule(int vehicleNumber, String vehicleDepartureTime) {
        repository.save(new TimeEntry(vehicleNumber, vehicleDepartureTime));
    }

    void editingTheVehicleFromTheSchedule(int editedOfTheNumberVehicle, String editTime) {
        Optional<TimeEntry> timeEntry = repository.findById(editedOfTheNumberVehicle);
        TimeEntry entry = timeEntry.orElseThrow(TimeTableController::busNotFound);
        entry.setTime(editTime);
        repository.save(entry);
    }

    void removedTheVehicleFromTheSchedule(int theVehicleNumberToBeRemoved) {
        Optional<TimeEntry> timeEntry = repository.findById(theVehicleNumberToBeRemoved);
        timeEntry.ifPresent(t -> repository.delete(t));
    }

    long databaseSize() {
        return repository.count();
    }

    List<TimeTableController.TimeTableEntry> getAllItems() {
        return repository.findAll().stream().map(r -> new TimeTableController.TimeTableEntry(r.number, r.time)).toList();
    }

    Optional<TimeTableController.TimeTableEntry> findElement(Integer number) {
        return repository.findById(number).map(r -> new TimeTableController.TimeTableEntry(r.number, r.time));
    }

    void printSchedule() {
        Displays.viewScheduleHeaderMessage();
        for (TimeEntry entry : repository.findAll()) {
            System.out.println("Vehicle number: " + entry.number + " departure time: " + entry.time);
        }
    }
}
