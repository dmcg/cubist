package com.oneeyedmen.cubist;

import org.junit.Rule;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;

import static com.oneeyedmen.cubist.Label.label;

public class HorizontalListPainterTest {

    @Rule
    public ImageApprovalsRule approver = ImageApprovalsRule.fileSystemRule("test");

    private final HorizontalListPainter painter = new HorizontalListPainter();

    @Test
    public void paint() throws IOException {
        Container container = new Container();
        container.add(label("Hello"), null);
        container.add(label("World"), null);
        container.add(label("!"), null);

        Graphics2D graphics = approver.graphics();
        painter.paint(container, graphics);
    }
}
