package domain.valueobject;

import java.util.Objects;

public class ReleaseID {
    private final String id;

    public ReleaseID(String id) {
        this.id = Objects.requireNonNull(id, "ReleaseID cannot be null");
    }

    public String getId() {
        return id;
    }
}