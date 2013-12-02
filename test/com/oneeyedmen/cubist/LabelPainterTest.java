package com.oneeyedmen.cubist;

import org.junit.Rule;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LabelPainterTest {

    @Rule public ImageApprovalsRule approver = ImageApprovalsRule.fileSystemRule("test");

    private final LabelPainter painter = new LabelPainter();

    @Test public void render() throws IOException {
        painter.paint(new Label(new LabelModel("Hello World")), approver.graphics());
    }
}
