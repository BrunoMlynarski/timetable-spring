package com.example.timetablespring.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TimeEntryRepository extends JpaRepository<TimeEntry, Integer> {
}
