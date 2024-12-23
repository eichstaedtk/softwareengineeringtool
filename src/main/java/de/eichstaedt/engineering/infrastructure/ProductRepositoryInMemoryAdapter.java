package de.eichstaedt.engineering.infrastructure;

import de.eichstaedt.engineering.domain.Product;
import de.eichstaedt.engineering.domain.ProductId;
import de.eichstaedt.engineering.domain.ProductRepositoryPort;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by konrad.eichstaedt@gmx.de on 06.12.24.
 */

@ApplicationScoped
public class ProductRepositoryInMemoryAdapter implements ProductRepositoryPort {

    private final Map<ProductId, Product> products;

    public ProductRepositoryInMemoryAdapter() {
        this.products = new HashMap<>();
    }

    @Override
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }
}
