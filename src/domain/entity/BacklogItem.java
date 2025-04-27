package domain.entity;

import domain.valueobject.*;
import java.util.*;

public class BacklogItem {
    private String status;
    private String story;
    private int storyPoints;
    private String summary;
    private String type;
    private final ProductID productID;
    private final ReleaseID releaseID;
    private final SprintID sprintID;
    private final List<Task> tasks = new ArrayList<>();

    public BacklogItem(String status, String story, int storyPoints, String summary, String type,
                       ProductID productID, ReleaseID releaseID, SprintID sprintID) {
        this.status = status;
        this.story = story;
        this.storyPoints = storyPoints;
        this.summary = summary;
        this.type = type;
        this.productID = productID;
        this.releaseID = releaseID;
        this.sprintID = sprintID;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public String getSummary() {
        return summary;
    }

    public int getStoryPoints() {
        return storyPoints;
    }
}