package de.eichstaedt.engineering.domain;

import de.eichstaedt.engineering.domain.SDLC.PHASE;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by konrad.eichstaedt@gmx.de on 12.09.24.
 * <p>
 * The goal of software engineering is to create proper products
 */
public class Product {

    public Product(String name) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name must not be empty");
        }

        this.id = UUID.nameUUIDFromBytes(name.getBytes(StandardCharsets.UTF_8)).toString();
        this.name = name;
        this.creationDate = LocalDateTime.now();
        this.phase = PHASE.PLANNING;
    }

    private final String id;
    private final String name;
    private final LocalDateTime creationDate;

    private final SDLC.PHASE phase;

    private URI gitUrl;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public PHASE getPhase() {
        return this.phase;
    }

    public URI getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(URI gitUrl) {
        this.gitUrl = gitUrl;
    }
}
