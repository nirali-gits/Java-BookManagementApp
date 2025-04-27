package domain.entity;

import domain.valueobject.EstimationLogEntry;
import java.util.*;

public class Task {
    private final String id;
    private String name;
    private String description;
    private int hoursRemaining;
    private String volunteer;
    private final List<EstimationLogEntry> estimationLogEntries = new ArrayList<>();

    public Task(String id, String name, String description, int hoursRemaining, String volunteer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hoursRemaining = hoursRemaining;
        this.volunteer = volunteer;
    }

    public void addEstimationLogEntry(EstimationLogEntry entry) {
        estimationLogEntries.add(entry);
        this.hoursRemaining = entry.getHoursRemaining();
    }

    public List<EstimationLogEntry> getEstimationLogEntries() {
        return Collections.unmodifiableList(estimationLogEntries);
    }

    public String getId() {
        return id;
    }

    public int getHoursRemaining() {
        return hoursRemaining;
    }
}
