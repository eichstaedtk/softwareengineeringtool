package de.eichstaedt.engineering.application;

import de.eichstaedt.engineering.domain.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class CloneProductService {

    private static final Logger logger = LoggerFactory.getLogger(CloneProductService.class);

    private final ProductRepositoryPort productRepository;
    private final GitOperations gitOperations;

    @Inject
    public CloneProductService(ProductRepositoryPort productRepository, GitOperations gitOperations) {
        this.productRepository = productRepository;
        this.gitOperations = gitOperations;
    }

    public void cloneProduct(ProductId productId) throws GitException {
        logger.info("Cloning product with id: {}", productId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));

        product.clone(gitOperations);
    }
} 