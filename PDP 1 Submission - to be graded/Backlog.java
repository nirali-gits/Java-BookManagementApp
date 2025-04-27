package domain.entity;

import java.util.*;

public class Backlog {
    private final UUID id;
    private final String name;
    private final String description;
    private final List<BacklogItem> backlogItems = new ArrayList<>();

    public Backlog(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void addBacklogItem(BacklogItem item) {
        backlogItems.add(item);
    }

    public List<BacklogItem> getBacklogItems() {
        return Collections.unmodifiableList(backlogItems);
    }

    public UUID getId() {
        return id;
    }
}