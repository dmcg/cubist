package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class HorizontalListPainter implements Painter<Container> {

    @Override public void paint(Container container, Graphics2D g) {
        for (int i = 0; i < container.components().size(); i++) {
            Container.PaintableAndContext each = container.components().get(i);
            each.paintable.paintOn(g);
            g.translate(each.paintable.preferredSize(g).getWidth(), 0);
        }
    }

    @Override
    public Dimension2D preferredSize(Container thing, Graphics2D g) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
