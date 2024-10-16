package de.eichstaedt.engineering.application;

import de.eichstaedt.engineering.domain.Product;
import io.quarkiverse.renarde.Controller;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jboss.resteasy.reactive.RestForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by konrad.eichstaedt@gmx.de on 25.09.24.
 */

@ApplicationScoped
public class IndexController extends Controller implements Serializable {

  Logger logger = LoggerFactory.getLogger(IndexController.class);

  private final List<Product> products = new ArrayList<>();

  @CheckedTemplate
  static class Templates {

    public static native TemplateInstance index(List<Product> products);
  }

  @Path("/index.html")
  public TemplateInstance index() {
    logger.info("Calling Index with number of products {}", products.size());
    return Templates.index(products);
  }

  @POST
  public void createProject(@RestForm String name) {
    logger.info("Creating new Project for {}", name);
    Product product = new Product(name);
    products.add(product);
    flash("message", "Product added");
    index();
  }

}
