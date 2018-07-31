package io.pivotal.pal.tracker;


import io.pivotal.pal.tracker.TimeEntry;
import io.pivotal.pal.tracker.TimeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeRepo;

    public TimeEntryController(TimeEntryRepository timeRepo) {
        this.timeRepo = timeRepo;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry res = timeRepo.create(timeEntryToCreate);

        return new ResponseEntity(res, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable  long id) {
        TimeEntry te = timeRepo.find(id);
        if(te==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(te, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity(timeRepo.list(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry expected) {
        TimeEntry te = timeRepo.update(id, expected);
        if(te==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(te, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
        timeRepo.delete(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }
}
