package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class HorizontalListPainter implements Painter<Container> {

    @Override public void paint(Container container, Graphics2D g, Dimension2D size, Palette palette) {
        for (Paintable paintable : container.components()) {
            Dimension2D preferredSize = paintable.preferredSize(g);
            paintable.paintOn(g, Dimensions.size(preferredSize.getWidth(), size.getHeight()));
            g.translate(preferredSize.getWidth(), 0);
        }
    }

    @Override
    public Dimension preferredSize(Container thing, Graphics2D g) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
