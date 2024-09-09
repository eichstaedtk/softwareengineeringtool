package de.eichstaedt.engineering.application;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.Endpoint;
import de.eichstaedt.engineering.domain.Projekt;
import jakarta.annotation.security.PermitAll;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by konrad.eichstaedt@gmx.de on 07.09.24.
 */

@Endpoint
@PermitAll
@AnonymousAllowed
public class ProjektController {

  private static final Logger logger = LoggerFactory.getLogger(ProjektController.class);

  private static final Map<String, Projekt> repository = new HashMap<>();

  public Projekt findProjekt() {
    return new Projekt("VDTest", "Vision Test");
  }

  public void saveProjekt(Projekt projekt) {
    logger.info("Creating new Projekt as {}", projekt);
    Projekt neuesProjekt = new Projekt(projekt.getName(), projekt.getVision());
    repository.put(neuesProjekt.getId(), neuesProjekt);
    logger.info("Save the projekt to map {} {}", repository.size(), neuesProjekt);
  }
}
