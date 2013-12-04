package com.oneeyedmen.cubist;

import org.rococoa.okeydoke.ApproverFactories;
import org.rococoa.okeydoke.ApproverFactory;
import org.rococoa.okeydoke.BinaryApprover;
import org.rococoa.okeydoke.junit.BinaryApprovalsRule;

import javax.imageio.ImageIO;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageApprovalsRule extends BinaryApprovalsRule {

    public static ImageApprovalsRule fileSystemRule(String sourceRoot, int width, int height) {
        return new ImageApprovalsRule(
                ApproverFactories.binaryFileSystemApproverFactory(new File(sourceRoot), ".png"),
                width, height);
    }

    private final int width;
    private final int height;

    private final BufferedImage image;

    public ImageApprovalsRule(ApproverFactory<BinaryApprover> factory, int width, int height) {
        super(factory);
        this.width = width;
        this.height = height;
        image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
    }

    public Graphics2D graphics() {
        return (Graphics2D) image.getGraphics();
    }

    public Dimension2D size() {
        return Dimensions.size(width, height);
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
