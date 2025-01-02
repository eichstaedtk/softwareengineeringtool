package de.eichstaedt.engineering.application;

import io.quarkiverse.renarde.Controller;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Created by konrad.eichstaedt@gmx.de on 02.01.25.
 */
@ApplicationScoped
public class FlashController extends Controller {

    public void flashSuccess(String message) {
        flash("message", message);
        flash("messageType", "success");
    }

    public void flashError(String message) {
        flash("message", message);
        flash("messageType", "error");
    }
}