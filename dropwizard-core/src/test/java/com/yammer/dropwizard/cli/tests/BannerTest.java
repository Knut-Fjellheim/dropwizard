package com.yammer.dropwizard.cli.tests;

import com.yammer.dropwizard.cli.BannerRenderer;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;

public class BannerTest {

    @Test
    public void generateBanner() throws IOException {
        final String message = "testing 1, 2, 3";
        final String banner = BannerRenderer.defaultRenderer().render(message);
        assertThat(banner).isNotEmpty();
    }
}
