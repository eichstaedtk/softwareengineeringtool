package de.eichstaedt.engineering.application;

import de.eichstaedt.engineering.domain.Product;
import de.eichstaedt.engineering.domain.ProductId;
import de.eichstaedt.engineering.domain.ProductRepositoryPort;
import io.quarkiverse.renarde.Controller;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by konrad.eichstaedt@gmx.de on 06.12.24.
 */

@ApplicationScoped
public class ProductsController extends Controller implements Serializable {

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Inject
    ProductRepositoryPort productRepository;

    @Inject
    CloneProductService cloneProductService;

    @CheckedTemplate
    static class Templates {
        public static native TemplateInstance products(List<Product> products);
    }

    @Path("/products.html")
    public TemplateInstance products() {
        logger.info("Calling Projects with number of products {}", productRepository.findAll());
        return ProductsController.Templates.products(productRepository.findAll())
                .data("flash", flash);
    }

    @GET
    @Path("/products/{id}/clone")
    public void cloneRepository(@PathParam("id") String id) {
        try {
            Product product = productRepository.findById(ProductId.of(id))
                    .orElseThrow(() -> new IllegalArgumentException("Product not found"));

            cloneProductService.cloneProduct(ProductId.of(id));
            flash("message", "Projekt '" + product.getName() + "' wurde erfolgreich geladen");
            flash("messageType", "success");
        } catch (Exception e) {
            logger.error("Failed to clone repository", e);
            flash("message", "Fehler beim herunterladen des Projekts: " + e.getMessage());
            flash("messageType", "error");
        }
        redirect(ProductsController.class).products();
    }
}
