package de.eichstaedt.engineering.application;

import de.eichstaedt.engineering.domain.Product;
import de.eichstaedt.engineering.domain.ProductRepositoryPort;
import io.quarkiverse.renarde.Controller;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
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
    ProductRepositoryPort productRepositoryPort;

    @CheckedTemplate
    static class Templates {
        public static native TemplateInstance products(List<Product> products);
    }

    @Path("/products.html")
    public TemplateInstance products() {
        logger.info("Calling Projects with number of products {}", productRepositoryPort.findAll());
        return ProductsController.Templates.products(productRepositoryPort.findAll());
    }
}
