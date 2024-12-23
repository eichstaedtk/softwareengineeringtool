package de.eichstaedt.engineering.domain;

import java.util.Objects;

public record ProductId(String value) {
    
    public ProductId {
        Objects.requireNonNull(value, "Product ID cannot be null");
    }

    public static ProductId create() {
        return new ProductId(java.util.UUID.randomUUID().toString());
    }

    public static ProductId of(String value) {
        return new ProductId(value);
    }
} 