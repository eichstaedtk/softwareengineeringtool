package de.eichstaedt.engineering.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import de.eichstaedt.engineering.domain.SDLC.PHASE;
import org.junit.jupiter.api.Test;

/**
 * Created by konrad.eichstaedt@gmx.de on 12.09.24.
 */
public class ProductTest {

  @Test
  void testStartLifeCylceOfProduct() {

    Product product = new Product("VD-Zukunft");

    assertNotNull(product);

    assertNotNull(product.getId());

    assertNotNull(product.getName());

    assertNotNull(product.getCreationDate());

    assertEquals(PHASE.PLANNING, product.getPhase());
  }
}
