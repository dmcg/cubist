package com.oneeyedmen.cubist;


import java.awt.*;
import java.awt.geom.Dimension2D;

public class LabelPainter implements Painter<Label> {

    @Override public void paint(Label label, Graphics2D g, Dimension2D size) {
        Graphics2D newG = (Graphics2D) g.create();
        newG.setColor(Color.BLACK);
        newG.translate(0, preferredSize(label, newG).getHeight());
        newG.drawString(label.model().text(), 0, 0);
    }

    @Override
    public Dimension2D preferredSize(Label thing, Graphics2D g) {
        return Dimensions.sizeOf(g.getFont().getStringBounds(thing.model().text(), g.getFontRenderContext()));
    }
}
