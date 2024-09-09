package de.eichstaedt.engineering.domain;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by konrad.eichstaedt@gmx.de on 07.09.24.
 * <p>
 * This Class represents the Root Aggregate for the Engineering Projekt
 */
public class Projekt {

  public Projekt(String name, String vision) {
    this.id = UUID.nameUUIDFromBytes(name.getBytes(StandardCharsets.UTF_8)).toString();
    this.name = name;
    this.vision = vision;
    this.erstellDatum = LocalDateTime.now();
  }

  private String id;

  private String name;

  private String vision;

  private LocalDateTime erstellDatum;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getVision() {
    return vision;
  }

  public LocalDateTime getErstellDatum() {
    return erstellDatum;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Projekt{");
    sb.append("id='").append(id).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", vision='").append(vision).append('\'');
    sb.append(", erstellDatum=").append(erstellDatum);
    sb.append('}');
    return sb.toString();
  }
}
