package com.oneeyedmen.cubist;

import org.junit.Rule;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class TextViewPainterTest {

    @Rule public ImageApprovalsRule approver = ImageApprovalsRule.fileSystemRule("test", 100, 100);

    private final TextViewPainter painter = new TextViewPainter();
    private final TextView textView = TextView.label("Hello World");

    @Test public void render() throws IOException {
        painter.paint(textView, approver.graphics(), textView.palette(), approver.size());
    }

    @Test public void render_with_palette() throws IOException {
        Font font = new Font("Arial", Font.BOLD, 18);
        assertNotNull(font);

        SimplePalette palette = new SimplePalette(font, Color.GREEN, Color.GRAY);
        painter.paint(textView, approver.graphics(), palette, approver.size());
    }

}
