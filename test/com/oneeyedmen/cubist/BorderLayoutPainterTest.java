package com.oneeyedmen.cubist;

import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static com.oneeyedmen.cubist.TextView.label;

public class BorderLayoutPainterTest {

    @Rule
    public ImageApprovalsRule approver = ImageApprovalsRule.fileSystemRule("test", 100, 100);

    private final BorderLayoutPainter painter = new BorderLayoutPainter();

    @Test
    public void paint_North_and_South() throws IOException {
        ContainerView container = new ContainerView();
        container.add(label("North"), BorderLayoutPainter.Position.NORTH);
        container.add(label("Jackdaws love my big sphinx of quartz"), BorderLayoutPainter.Position.SOUTH);
        painter.paint(container, approver.graphics(), approver.size(), null);
    }
}
