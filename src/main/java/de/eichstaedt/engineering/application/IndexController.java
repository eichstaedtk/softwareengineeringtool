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
import java.net.URI;
import java.nio.file.Paths;
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
        logger.info("Calling Index Page");
        return Templates.index();
    }

    @POST
    public void createProject(@RestForm String name, 
                            @RestForm String gitUrl,
                            @RestForm String localDirectory) {
        logger.info("Creating new Project {} with Git URL {} and local directory {}", 
                   name, gitUrl, localDirectory);
                   
        Product product;
        if (gitUrl != null && !gitUrl.isEmpty()) {
            product = new Product(name, URI.create(gitUrl));
        } else {
            product = new Product(name);
        }
        
        if (localDirectory != null && !localDirectory.isEmpty()) {
            product.setLocalDirectory(Paths.get(localDirectory));
        }
        
        productRepositoryPort.addProduct(product);
        redirect(ProductsController.class).products();
    }

}
