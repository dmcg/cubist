package com.oneeyedmen.cubist;


import java.awt.*;
import java.awt.geom.Dimension2D;

public class TextViewPainter implements Painter<TextView> {

    @Override public void paint(TextView textView, Graphics2D g, Palette palette, Dimension2D size) {
        Graphics2D newG = (Graphics2D) g.create();
        palette.configure(newG);
        newG.translate(0, preferredSize(textView, newG, palette).getHeight());
        newG.drawString(textView.model().text(), 0, 0);
    }

    @Override
    public Dimension2D preferredSize(TextView thing, Graphics2D g, Palette palette) {
        return Dimensions.sizeOf(palette.font().getStringBounds(thing.model().text(), g.getFontRenderContext()));
    }
}
