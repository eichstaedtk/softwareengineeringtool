package de.eichstaedt.engineering.application;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by konrad.eichstaedt@gmx.de on 12.09.24.
 */
@QuarkusTest
class IndexPageTest {

  @TestHTTPResource("index.html")
  URL url;

  @Test
  void testIndexHtml() throws IOException {
    try (InputStream in = url.openStream()) {
      String contents = new String(in.readAllBytes(), StandardCharsets.UTF_8);
      Assertions.assertTrue(contents.contains("WELCOME TO PURE SOFTWARE-ENGINEERING"));
    }
  }

}
