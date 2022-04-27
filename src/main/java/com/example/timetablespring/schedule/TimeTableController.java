package com.example.timetablespring.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
class TimeTableController {
    private final DataBaseOfScheduledVehicles database;

    @GetMapping(value = "/timetable")
    List<TimeTableEntry> getTimeTable() {
        return database.getAllItems();
    }

    @GetMapping(value = "/timetable/{number}")
    TimeTableEntry getOneElement(@PathVariable Integer number) {
        return database.findElement(number).orElseThrow(TimeTableController::busNotFound);
    }

    @PostMapping(value = "/timetable")
    @ResponseStatus(HttpStatus.CREATED)
    void createTimeTableRecord(@RequestBody TimeTableEntry entry) {
        database.addNewVehicleToSchedule(entry.number, entry.time);
    }

    @PutMapping(value = "/timetable/{number}")
    void updateTimeTableRecord(@PathVariable Integer number, @RequestBody TimeTableEntry entry) {
        database.editingTheVehicleFromTheSchedule(number, entry.time);
    }

    @DeleteMapping(value = "/timetable/{number}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTimeTableRecord(@PathVariable Integer number) {
        database.removedTheVehicleFromTheSchedule(number);
    }

    public static ResponseStatusException busNotFound() {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Bus not found");
    }

    record TimeTableEntry(Integer number, String time) {}

//    @GetMapping(value = "/timetable/{number}/time/{time}")
//    @ResponseStatus(HttpStatus.CREATED)
//    void createTimeTableRecord(@PathVariable Integer number, @PathVariable String time) {
//        database.addNewVehicleToSchedule(number, time);
//    }
}
