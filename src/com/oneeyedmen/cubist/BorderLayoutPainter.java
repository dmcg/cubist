package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class BorderLayoutPainter implements Painter<Container> {

    public enum Position {
        NORTH {
            @Override
            protected void paint(Paintable paintable, Graphics2D g, Dimension2D size) {
                Dimension2D preferredSize = paintable.preferredSize(g);
                double centerX = (size.getWidth() - preferredSize.getWidth()) / 2;
                g.translate(centerX, 0);
                paintable.paintOn(g, Dimensions.size(size.getWidth(), preferredSize.getHeight()));
            }
        },
        SOUTH {
            @Override
            protected void paint(Paintable paintable, Graphics2D g, Dimension2D size) {
                Dimension2D preferredSize = paintable.preferredSize(g);
                double centerX = (size.getWidth() - preferredSize.getWidth()) / 2;
                g.translate(centerX, size.getHeight() - preferredSize.getHeight());
                paintable.paintOn(g, Dimensions.size(size.getWidth(), preferredSize.getHeight()));
            }
        };

        protected void paint(Paintable paintable, Graphics2D g, Dimension2D size) {

        }
    }

    @Override
    public void paint(Container container, Graphics2D g, Dimension2D size) {
        for (Paintable paintable : container.components()) {
            Object context = container.contextFor(paintable);
            if (!(context instanceof Position))
                throw new IllegalStateException("Expected a Position");
            ((Position) context).paint(paintable, (Graphics2D) g.create(), size);
        }
    }


    @Override
    public Dimension preferredSize(Container thing, Graphics2D g) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
