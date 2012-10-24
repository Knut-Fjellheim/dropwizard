package com.yammer.dropwizard.cli.tests;

import com.yammer.dropwizard.cli.BannerRenderer;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;

public class BannerTest {

    @Test
    public void generateBanner() throws IOException {
        final String message =
                "The quick, brown fox (fox@gmail.com / hello!), jumped over the lazy dog. 1 + 9 -" +
                        " 37 == 56%";
        final String banner = BannerRenderer.defaultRenderer().render(message);
        assertThat(banner).isNotEmpty();

        try {
            final File f = new File("test-banner.txt");
            final FileOutputStream fos = new FileOutputStream(f);
            fos.write(banner.getBytes());
        } catch (IOException e) {
            // nowt
        }
    }
}
