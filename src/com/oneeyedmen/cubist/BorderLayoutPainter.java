package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class BorderLayoutPainter implements Painter<Container> {

    public enum Position {
        NORTH, SOUTH, EAST, WEST, CENTER
    }

    @Override
    public void paint(Container container, Graphics2D g, Dimension2D size) {
        for (Paintable paintable : container.components()) {
            Graphics2D newG = (Graphics2D) g.create();
            Object context = container.contextFor(paintable);
            if (context == Position.NORTH) {
                Dimension2D preferredSize = paintable.preferredSize(newG);
                double centerX = (size.getWidth() - preferredSize.getWidth()) / 2;
                newG.translate(centerX, 0);
                paintable.paintOn(newG, Dimensions.size(size.getWidth(), preferredSize.getHeight()));
            } else if (context == Position.SOUTH) {
                Dimension2D preferredSize = paintable.preferredSize(newG);
                double centerX = (size.getWidth() - preferredSize.getWidth()) / 2;
                newG.translate(centerX, size.getHeight() - preferredSize.getHeight());
                paintable.paintOn(newG, Dimensions.size(size.getWidth(), preferredSize.getHeight()));
            }
        }
    }

    @Override
    public Dimension preferredSize(Container thing, Graphics2D g) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
