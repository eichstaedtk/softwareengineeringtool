package de.eichstaedt.engineering.domain;

import java.time.LocalDateTime;

/**
 * Created by konrad.eichstaedt@gmx.de on 30.10.24.
 */
public abstract class Requirement {

  protected String id;

  protected String name;
  protected String description;
  protected LocalDateTime creationDate;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }
}
