package domain.valueobject;

public class EstimationLogEntry {
    private final String name;
    private final String description;
    private final int hoursRemaining;
    private final String volunteer;

    public EstimationLogEntry(String name, String description, int hoursRemaining, String volunteer) {
        this.name = name;
        this.description = description;
        this.hoursRemaining = hoursRemaining;
        this.volunteer = volunteer;
    }

    public String getName() {
        return name;
    }

    public int getHoursRemaining() {
        return hoursRemaining;
    }

    public String getDescription() {
        return description;
    }

    public String getVolunteer() {
        return volunteer;
    }
}