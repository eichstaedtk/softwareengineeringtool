package de.eichstaedt.engineering.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Created by konrad.eichstaedt@gmx.de on 30.10.24.
 */
public class RequirementTest {

  @Test
  void testCreateRequirement() {

    Requirement requirement = new UseCase("UC001", "Buy Stocks over Web");

    assertNotNull(requirement);
  }
}
