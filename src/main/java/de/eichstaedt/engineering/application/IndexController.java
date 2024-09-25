package de.eichstaedt.engineering.application;

import io.quarkiverse.renarde.Controller;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.Path;

/**
 * Created by konrad.eichstaedt@gmx.de on 25.09.24.
 */
public class IndexController extends Controller {

  @CheckedTemplate
  static class Templates {

    public static native TemplateInstance index();
  }

  @Path("/index.html")
  public TemplateInstance index() {
    return Templates.index();
  }

}
