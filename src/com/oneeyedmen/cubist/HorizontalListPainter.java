package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class HorizontalListPainter implements Painter<ContainerView> {

    @Override public void paint(ContainerView container, Graphics2D g, Palette palette, Dimension2D size) {
        for (Paintable paintable : container.contents()) {
            Dimension2D preferredSize = paintable.preferredSize(g);
            paintable.paintOn(g, Dimensions.size(preferredSize.getWidth(), size.getHeight()));
            g.translate(preferredSize.getWidth(), 0);
        }
    }

    @Override
    public Dimension preferredSize(ContainerView thing, Graphics2D g, Palette palette) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
