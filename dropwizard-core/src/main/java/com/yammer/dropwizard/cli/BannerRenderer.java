package com.yammer.dropwizard.cli;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Generates an ASCII art banner for an image or message.
 */
public class BannerRenderer {

    private static final Graphics2D context =
            new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_GRAY)
                    .createGraphics();

    private final Font font;
    private final FontMetrics metrics;
    private final int height;
    private final int offset;
    private final int canvasHeight;

    public static BannerRenderer defaultRenderer() {
        return new BannerRenderer(new Font(Font.DIALOG, Font.BOLD, 16));
    }

    public BannerRenderer(final String font) {
        this(Font.getFont(font));
    }

    public BannerRenderer(final Font font) {
        checkNotNull(font);
        this.font = font;
        metrics = context.getFontMetrics(font);
        height = metrics.getHeight();
        offset = (int) (0.2 * height);
        canvasHeight = height + (2 * offset);
    }

    public String render(final BufferedImage image) {
        final StringBuilder sb = new StringBuilder();
        final PixelRenderer renderer = new SimplePixelRenderer(image);
        for (int y = 0; y < canvasHeight; y++) {
            final StringBuilder line = new StringBuilder();
            for (int x = 0; x < image.getWidth(); x++) {
                line.append(renderer.render(x, y));
            }
            if (!line.toString().trim().isEmpty()) {
                sb.append(line);
                sb.append("\n");
            }
        }
//
//        try {
//            final File f = new File("test-banner.txt");
//            final FileOutputStream fos = new FileOutputStream(f);
//            fos.write(sb.toString().getBytes());
//            ImageIO.write(image, "png", new File("banner-image.png"));
//        } catch (IOException e) {
//            // nowt
//        }

        return sb.toString();
    }

    public String render(final String message) {
        final int width = metrics.stringWidth(message);
        final int canvasWidth = width + (2 * offset);
        final BufferedImage image =
                new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_BYTE_GRAY);
        final Graphics2D context = (Graphics2D) image.getGraphics();
        context.setFont(font);
        context.drawString(message, offset, height);
        return render(image);
    }

    interface PixelRenderer {
        public char render(int x, int y);
    }

    class SimplePixelRenderer implements PixelRenderer {

        private static final int BLACK = 0xFF000000;
        private static final int WHITE = 0xFFFFFFFF;

        private final BufferedImage image;

        public SimplePixelRenderer(final BufferedImage image) {
            this.image = image;
        }

        public char render(final int x, final int y) {
            final int rgb = image.getRGB(x, y);
            return rgb == BLACK ? ' ' : (rgb == WHITE ? '#' : '*');
        }
    }
}
