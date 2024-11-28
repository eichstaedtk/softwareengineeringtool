package de.eichstaedt.engineering.domain;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by konrad.eichstaedt@gmx.de on 30.10.24.
 * <p>
 * A use case captures a contract between the stakeholders of a system about its behavior.
 */

public class UseCase extends Requirement {

  public UseCase(String name, String description) {
    this.id = UUID.nameUUIDFromBytes(name.getBytes()).toString();
    this.name = name;
    this.description = description;
    this.creationDate = LocalDateTime.now();
  }
}
