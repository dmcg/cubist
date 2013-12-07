package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class BorderLayoutPainter implements Painter<ContainerView> {

    public enum Position {
        NORTH {
            @Override
            protected Bounds place(Dimension2D size, Dimension2D preferredSize) {
                double centerX = (size.getWidth() - preferredSize.getWidth()) / 2;
                return new Bounds(centerX, 0, size.getWidth(),
                        preferredSize.getHeight());
            }
        },
        SOUTH {
            @Override
            protected Bounds place(Dimension2D size, Dimension2D preferredSize) {
                double centerX = (size.getWidth() - preferredSize.getWidth()) / 2;
                return new Bounds(centerX, size.getHeight() - preferredSize.getHeight(),
                        size.getWidth(), preferredSize.getHeight());
            }
        };

        protected abstract Bounds place(Dimension2D size, Dimension2D preferredSize);
    }

    @Override
    public void paint(ContainerView container, Graphics2D g, Dimension2D size, Palette palette) {
        for (Paintable paintable : container.contents()) {
            Object context = container.contextFor(paintable);
            if (!(context instanceof Position))
                throw new IllegalStateException("Expected a Position");
            Graphics2D newG = (Graphics2D) g.create();
            Bounds bounds = ((Position) context).place(size, paintable.preferredSize(newG));
            newG.translate(bounds.getX(), bounds.getY());
            paintable.paintOn(newG, Dimensions.size(bounds.getWidth(), bounds.getHeight()));
            if (paintable instanceof Bounded) {
                // TODO - not here - this will make a repaint when we listen to bounds
                ((Bounded) paintable).bounds().setRect(bounds);
            }
        }
    }


    @Override
    public Dimension preferredSize(ContainerView thing, Graphics2D g) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
