package de.eichstaedt.engineering.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import de.eichstaedt.engineering.domain.SDLC.PHASE;
import java.net.URI;
import java.nio.file.Path;
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

  @Test
  void testCreateProductWithGitUrl() {
    // Given
    String productName = "Test-Project";
    URI gitUrl = URI.create("https://github.com/user/test-project");

    // When
    Product product = new Product(productName, gitUrl);

    // Then
    assertNotNull(product);
    assertEquals(productName, product.getName());
    assertEquals(gitUrl, product.getGitUrl());
    assertEquals("https", product.getGitUrl().getScheme());
    assertEquals("github.com", product.getGitUrl().getHost());
    assertEquals("/user/test-project", product.getGitUrl().getPath());
  }

  @Test
  void testCreateProductWithLocalDirectory() {
    // Given
    String productName = "Local-Project";
    Path localDirectory = Path.of("/projects/local-project");

    // When
    Product product = new Product(productName);
    product.setLocalDirectory(localDirectory);

    // Then
    assertNotNull(product);
    assertEquals(productName, product.getName());
    assertEquals(localDirectory, product.getLocalDirectory());
    assertEquals("/projects/local-project", product.getLocalDirectory().toString());
  }
}
