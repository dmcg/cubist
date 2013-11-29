package com.oneeyedmen.cubist;

import org.junit.Rule;
import org.junit.Test;
import org.rococoa.okeydoke.junit.BinaryApprovalsRule;

import javax.imageio.ImageIO;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LabelRendererTest {

    @Rule public BinaryApprovalsRule approver = BinaryApprovalsRule.fileSystemRule("test", ".png");

    @Test public void render_text() throws IOException {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        new LabelRenderer("Hello World").render(g, 10, 10);
        ImageIO.write(image, "PNG", new MemoryCacheImageOutputStream(approver.outputStream()));
    }
}
