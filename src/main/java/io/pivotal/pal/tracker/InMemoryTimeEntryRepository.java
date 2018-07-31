package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {


    Map<Long,TimeEntry> map =new HashMap<>();
    private long counter = 1;

    @Override
    public TimeEntry create(TimeEntry te) {
        TimeEntry createdTimeEntry = new TimeEntry(counter, te.getProjectId(), te.getUserId(), te.getDate(), te.getHours());

        map.put(counter++, createdTimeEntry);
        return  createdTimeEntry;
    }

    @Override
    public TimeEntry find(long id) {

       return map.get(id);

    }

    public List<TimeEntry> list() {
        return new ArrayList<>(map.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {

        if(map.containsKey(id)) {
            map.put(id, timeEntry);
            timeEntry.setId(id);
            return timeEntry;
        }

        return null;
    }

    @Override
    public TimeEntry delete(long id) {

        return map.remove(id);
    }
}
