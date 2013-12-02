package com.oneeyedmen.cubist;

import org.junit.Rule;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.oneeyedmen.cubist.Label.label;

public class ContainerRendererTest {

    @Rule
    public ImageApprovalsRule approver = ImageApprovalsRule.fileSystemRule("test");

    private final ContainerRenderer renderer = new ContainerRenderer();
    private final BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
    private final Graphics2D g = (Graphics2D) image.getGraphics();

    @Test
    public void no_layout() throws IOException {
        Container container = new Container();
        container.add(label("Hello"));
        container.add(label("World"));
        g.translate(10, 30);
        renderer.render(container, g);
        approver.writeImage(image);
    }
}
