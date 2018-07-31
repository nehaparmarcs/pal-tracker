package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry te);

    TimeEntry find(long id);

    public List<TimeEntry> list();

    TimeEntry update(long id, TimeEntry timeEntry);

    void delete(long id);
}
