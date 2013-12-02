package com.oneeyedmen.cubist;

import org.junit.Rule;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.oneeyedmen.cubist.Label.label;

public class ContainerPainterTest {

    @Rule
    public ImageApprovalsRule approver = ImageApprovalsRule.fileSystemRule("test");

    private final ContainerPainter painter = new ContainerPainter();

    @Test
    public void no_layout() throws IOException {
        Container container = new Container();
        container.add(label("Hello"));
        container.add(label("World"));

        Graphics2D graphics = approver.graphics();
        graphics.translate(10, 30);
        painter.paint(container, graphics);
    }
}
