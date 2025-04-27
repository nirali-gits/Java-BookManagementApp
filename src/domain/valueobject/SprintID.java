package domain.valueobject;

import java.util.Objects;

public class SprintID {
    private final String id;

    public SprintID(String id) {
        this.id = Objects.requireNonNull(id, "SprintID cannot be null");
    }

    public String getId() {
        return id;
    }
}
