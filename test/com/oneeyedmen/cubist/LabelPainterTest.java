package com.oneeyedmen.cubist;

import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

public class LabelPainterTest {

    @Rule public ImageApprovalsRule approver = ImageApprovalsRule.fileSystemRule("test", 100, 100);

    private final LabelPainter painter = new LabelPainter();

    @Test public void render() throws IOException {
        painter.paint(Label.label("Hello World"), approver.graphics(), approver.size());
    }
}
