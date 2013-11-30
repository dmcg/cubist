package com.oneeyedmen.cubist;

import org.rococoa.okeydoke.ApproverFactories;
import org.rococoa.okeydoke.ApproverFactory;
import org.rococoa.okeydoke.BinaryApprover;
import org.rococoa.okeydoke.junit.BinaryApprovalsRule;

import javax.imageio.ImageIO;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageApprovalsRule extends BinaryApprovalsRule {

    public static ImageApprovalsRule fileSystemRule(String sourceRoot) {
        return new ImageApprovalsRule(ApproverFactories.binaryFileSystemApproverFactory(new File(sourceRoot), ".png"));
    }
    
    public ImageApprovalsRule(ApproverFactory<BinaryApprover> factory) {
        super(factory);
    }

    public void writeImage(BufferedImage image) throws IOException {
        ImageIO.write(image, "PNG", new MemoryCacheImageOutputStream(outputStream()));
    }
}
