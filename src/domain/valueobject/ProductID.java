package domain.valueobject;

import java.util.Objects;

public class ProductID {
    private final String id;

    public ProductID(String id) {
        this.id = Objects.requireNonNull(id, "ProductID cannot be null");
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductID)) return false;
        ProductID other = (ProductID) o;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}