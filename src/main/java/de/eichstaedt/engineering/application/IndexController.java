package de.eichstaedt.engineering.application;

import de.eichstaedt.engineering.domain.Product;
import de.eichstaedt.engineering.domain.ProductRepositoryPort;
import io.quarkiverse.renarde.Controller;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.reactive.RestForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by konrad.eichstaedt@gmx.de on 25.09.24.
 */

@ApplicationScoped
public class IndexController extends Controller implements Serializable {

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Inject
    ProductRepositoryPort productRepositoryPort;

    @CheckedTemplate
    static class Templates {

        public static native TemplateInstance index();
    }

    @Path("/index.html")
    public TemplateInstance index() {
        logger.info("Calling Index Page", productRepositoryPort.findAll().size());
        return Templates.index();
    }

    @POST
    public void createProject(@RestForm String name) {
        logger.info("Creating new Project for {}", name);
        Product product = new Product(name);
        productRepositoryPort.addProduct(product);
        redirect(ProductsController.class).products();
    }

}
