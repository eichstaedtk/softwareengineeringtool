package de.eichstaedt.engineering.domain;

import java.util.List;
import java.util.Optional;

/**
 * Created by konrad.eichstaedt@gmx.de on 06.12.24.
 */
public interface ProductRepositoryPort {

    void addProduct(Product product);

    List<Product> findAll();

    Optional<Product> findById(ProductId productId);

}
