package de.eichstaedt.engineering.infrastructure;

import de.eichstaedt.engineering.domain.GitOperations;
import de.eichstaedt.engineering.domain.Product;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class JGitOperations implements GitOperations {
    
    private static final Logger logger = LoggerFactory.getLogger(JGitOperations.class);

    @Override
    public void clone(Product product) {
        try {
            Git.cloneRepository()
                .setURI(product.getGitUrl().toString())
                .setDirectory(product.getLocalDirectory().toFile())
                .call();
            logger.info("Successfully cloned repository for product {}", product.getId());
        } catch (GitAPIException e) {
            logger.error("Failed to clone repository for product {}", product.getId(), e);
            throw new RuntimeException("Failed to clone repository", e);
        }
    }
} 