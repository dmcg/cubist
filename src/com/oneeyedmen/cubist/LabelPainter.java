package com.oneeyedmen.cubist;


import java.awt.*;
import java.awt.geom.Dimension2D;

public class LabelPainter implements Painter<TextView> {

    @Override public void paint(TextView textView, Graphics2D g, Dimension2D size, Palette palette) {
        Graphics2D newG = (Graphics2D) g.create();
        palette.configure(newG);
        newG.translate(0, preferredSize(textView, newG).getHeight());
        newG.drawString(textView.model().text(), 0, 0);
    }

    @Override
    public Dimension2D preferredSize(TextView thing, Graphics2D g) {
        return Dimensions.sizeOf(g.getFont().getStringBounds(thing.model().text(), g.getFontRenderContext()));
    }
}
