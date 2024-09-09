package de.eichstaedt.engineering.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Created by konrad.eichstaedt@gmx.de on 07.09.24.
 */
public class ProjektTest {

  @Test
  void testNeuesProjektAnlegen() {
    Projekt projekt = new Projekt("VD-Zukunft",
        "Ein Portal für alle Daten des Verzeichnis der Drucke vom 16. bis zum 19. Jahrhundert. ");
    assertNotNull(projekt);
    assertNotNull(projekt.getId());
    assertNotNull(projekt.getName());
    assertNotNull(projekt.getVision());
    assertNotNull(projekt.getErstellDatum());
  }
}
