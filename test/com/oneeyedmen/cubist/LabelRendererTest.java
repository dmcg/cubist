package com.oneeyedmen.cubist;

import org.junit.Rule;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LabelRendererTest {

    @Rule public ImageApprovalsRule approver = ImageApprovalsRule.fileSystemRule("test");

    private final LabelRenderer renderer = new LabelRenderer();
    private final BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
    private final Graphics2D g = (Graphics2D) image.getGraphics();

    @Test public void render_text_0_0() throws IOException {
        renderer.render(new Label(new LabelModel("Hello World")), g, 0, 0);
        approver.writeImage(image);
    }


    @Test public void render_text_10_30() throws IOException {
        renderer.render(new Label(new LabelModel("Hello World")), g, 10, 30);
        approver.writeImage(image);
    }
}
