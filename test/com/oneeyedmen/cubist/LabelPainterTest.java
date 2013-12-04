package com.oneeyedmen.cubist;

import org.junit.Rule;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class LabelPainterTest {

    @Rule public ImageApprovalsRule approver = ImageApprovalsRule.fileSystemRule("test", 100, 100);

    private final LabelPainter painter = new LabelPainter();
    private final Label label = Label.label("Hello World");

    @Test public void render() throws IOException {
        painter.paint(label, approver.graphics(), approver.size(), label.palette());
    }

    @Test public void render_with_palette() throws IOException {
        Font font = new Font("Arial", Font.BOLD, 18);
        assertNotNull(font);

        SimplePalette palette = new SimplePalette(font, Color.GREEN);
        painter.paint(label, approver.graphics(), approver.size(), palette);
    }

}
