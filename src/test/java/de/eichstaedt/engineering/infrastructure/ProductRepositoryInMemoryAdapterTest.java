package de.eichstaedt.engineering.infrastructure;

import de.eichstaedt.engineering.domain.Product;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by konrad.eichstaedt@gmx.de on 06.12.24.
 */
public class ProductRepositoryInMemoryAdapterTest {

    @ParameterizedTest
    @ValueSource(strings = {"VDZukunft", "Sonar"})
    void testAddProduct(String product) {
        ProductRepositoryInMemoryAdapter adapter = new ProductRepositoryInMemoryAdapter();
        adapter.addProduct(new Product(product));
        assertEquals(1, adapter.findAll().size());
    }
}
