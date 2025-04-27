import domain.entity.*;
import domain.valueobject.*;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ProductID productID = new ProductID("prod-123");
        ReleaseID releaseID = new ReleaseID("rel-2025A");
        SprintID sprintID = new SprintID("sprint-4");

        BacklogItem item = new BacklogItem("To Do", "Implement login", 8,
                "User authentication", "Feature", productID, releaseID, sprintID);

        Task task1 = new Task("t1", "Backend Logic", "Implement user authentication service", 5, "Alice");
        task1.addEstimationLogEntry(new EstimationLogEntry("Initial Estimate", "Planning phase", 5, "Alice"));
        task1.addEstimationLogEntry(new EstimationLogEntry("Updated", "Adjusted after review", 4, "Alice"));

        item.addTask(task1);

        Backlog backlog = new Backlog(UUID.randomUUID(), "Authentication Module", "Backlog for user auth tasks");
        backlog.addBacklogItem(item);

        System.out.println("Backlog: " + backlog.getId());
        for (BacklogItem bi : backlog.getBacklogItems()) {
            System.out.println("  Item: " + bi.getSummary() + " (" + bi.getStoryPoints() + " points)");
            for (Task t : bi.getTasks()) {
                System.out.println("    Task: " + t.getId() + " - " + t.getHoursRemaining() + " hrs left");
            }
        }
    }
}
