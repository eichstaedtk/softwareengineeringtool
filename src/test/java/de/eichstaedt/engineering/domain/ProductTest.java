package de.eichstaedt.engineering.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URI;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductTest {

    @Mock
    private GitOperations gitOperations;

    @Test
    void shouldBeCloneableWithGitUrlAndLocalDirectory() {
        // Given
        Product product = new Product("Test Product");
        product.setGitUrl(URI.create("https://github.com/test/repo.git"));
        product.setLocalDirectory(Path.of("/tmp/test"));

        // Then
        assertTrue(product.isCloneable());
    }

    @Test
    void shouldNotBeCloneableWithoutGitUrl() {
        // Given
        Product product = new Product("Test Product");
        product.setLocalDirectory(Path.of("/tmp/test"));

        // Then
        assertFalse(product.isCloneable());
    }

    @Test
    void shouldNotBeCloneableWithoutLocalDirectory() {
        // Given
        Product product = new Product("Test Product");
        product.setGitUrl(URI.create("https://github.com/test/repo.git"));

        // Then
        assertFalse(product.isCloneable());
    }

    @Test
    void shouldCloneSuccessfully() throws GitException {
        // Given
        Product product = new Product("Test Product");
        product.setGitUrl(URI.create("https://github.com/test/repo.git"));
        product.setLocalDirectory(Path.of("/tmp/test"));

        // When
        product.clone(gitOperations);

        // Then
        verify(gitOperations).clone(product);
    }

    @Test
    void shouldThrowExceptionWhenCloningWithoutGitUrl() {
        // Given
        Product product = new Product("Test Product");
        product.setLocalDirectory(Path.of("/tmp/test"));

        // Then
        assertThrows(IllegalStateException.class, () -> product.clone(gitOperations));
    }

    @Test
    void shouldThrowExceptionWhenCloningWithoutLocalDirectory() {
        // Given
        Product product = new Product("Test Product");
        product.setGitUrl(URI.create("https://github.com/test/repo.git"));

        // Then
        assertThrows(IllegalStateException.class, () -> product.clone(gitOperations));
    }

    @Test
    void shouldAddUseCaseToProduct() {
        // Given
        Product product = new Product("Test Product");
        UseCase useCase = new UseCase("Login", "User can log into the system");

        // When
        product.addUseCase(useCase);

        // Then
        assertTrue(product.getUseCases().contains(useCase));
        assertEquals(1, product.getUseCases().size());
    }

    @Test
    void shouldNotAllowNullUseCase() {
        // Given
        Product product = new Product("Test Product");

        // Then
        assertThrows(IllegalArgumentException.class, () -> product.addUseCase(null));
    }

    @Test
    void shouldProvideUnmodifiableUseCaseList() {
        // Given
        Product product = new Product("Test Product");
        product.addUseCase(new UseCase("Login", "User can log into the system"));

        // When
        var useCases = product.getUseCases();

        // Then
        assertThrows(UnsupportedOperationException.class, 
            () -> useCases.add(new UseCase("Register", "User can register")));
    }
}
