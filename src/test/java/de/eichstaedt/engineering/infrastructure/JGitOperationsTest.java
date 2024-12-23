package de.eichstaedt.engineering.infrastructure;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import de.eichstaedt.engineering.domain.Product;
import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class JGitOperationsTest {

    @TempDir
    Path tempDir;

    @Test
    void shouldCloneRepository() {
        // Given
        JGitOperations gitOperations = new JGitOperations();
        Product product = new Product("Test Product");
        
        // Using a real public repository for testing
        product.setGitUrl(URI.create("https://github.com/quarkusio/quarkus-quickstarts.git"));
        product.setLocalDirectory(tempDir);

        // When
        gitOperations.clone(product);

        // Then
        File gitDir = new File(tempDir.toFile(), ".git");
        assertTrue(gitDir.exists());
        assertTrue(gitDir.isDirectory());
    }
} 