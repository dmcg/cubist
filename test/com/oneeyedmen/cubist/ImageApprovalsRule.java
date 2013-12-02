package com.oneeyedmen.cubist;

import org.rococoa.okeydoke.ApproverFactories;
import org.rococoa.okeydoke.ApproverFactory;
import org.rococoa.okeydoke.BinaryApprover;
import org.rococoa.okeydoke.junit.BinaryApprovalsRule;

import javax.imageio.ImageIO;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageApprovalsRule extends BinaryApprovalsRule {

    public static ImageApprovalsRule fileSystemRule(String sourceRoot) {
        return new ImageApprovalsRule(ApproverFactories.binaryFileSystemApproverFactory(new File(sourceRoot), ".png"));
    }

    private final BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

    public ImageApprovalsRule(ApproverFactory<BinaryApprover> factory) {
        super(factory);
    }

    public Graphics2D graphics() {
        return (Graphics2D) image.getGraphics();
    }

    public void assertSatisfied() {
        writeImage(image);
        super.assertSatisfied();
    }

    private void writeImage(BufferedImage image) {
        try {
            ImageIO.write(image, "PNG", new MemoryCacheImageOutputStream(outputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
