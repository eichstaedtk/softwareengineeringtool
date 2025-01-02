package de.eichstaedt.engineering.domain;

/**
 * Domain Service für Git-Operationen
 */
public interface GitOperations {
    void clone(Product product) throws GitException;
} 