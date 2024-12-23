package de.eichstaedt.engineering.domain;

import de.eichstaedt.engineering.domain.SDLC.PHASE;
import java.net.URI;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by konrad.eichstaedt@gmx.de on 12.09.24.
 * <p>
 * The goal of software engineering is to create proper products
 */
public class Product {

    private final ProductId id;
    private String name;
    private final LocalDateTime creationDate;
    private PHASE phase;
    private URI gitUrl;
    private Path localDirectory;

    public Product(String name) {
        this.id = ProductId.create();
        this.name = Objects.requireNonNull(name, "Product name cannot be null");
        this.creationDate = LocalDateTime.now();
        this.phase = PHASE.PLANNING;
    }

    public Product(String name, URI gitUrl) {
        this(name);
        this.gitUrl = Objects.requireNonNull(gitUrl, "Git URL cannot be null");
    }

    public ProductId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public PHASE getPhase() {
        return phase;
    }

    public URI getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(URI gitUrl) {
        this.gitUrl = Objects.requireNonNull(gitUrl, "Git URL cannot be null");
    }

    public Path getLocalDirectory() {
        return localDirectory;
    }

    public void setLocalDirectory(Path localDirectory) {
        this.localDirectory = Objects.requireNonNull(localDirectory, "Local directory cannot be null");
    }

    public void clone(GitOperations gitOperations) {
        if (gitUrl == null) {
            throw new IllegalStateException("Cannot clone product without Git URL");
        }
        if (localDirectory == null) {
            throw new IllegalStateException("Cannot clone product without local directory");
        }
        gitOperations.clone(this);
    }

    public boolean isCloneable() {
        return gitUrl != null && localDirectory != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phase=" + phase +
                ", gitUrl=" + gitUrl +
                ", localDirectory=" + localDirectory +
                '}';
    }
}
