package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class LabelPainter implements Painter<Label> {

    @Override public void paint(Label label, Graphics2D g, Palette palette, Dimension2D size) {
        Graphics2D newG = (Graphics2D) g.create();
        palette.paintBackground(newG, size);
        palette.configure(newG);
        newG.translate(0, preferredSize(label, newG, palette).getHeight());
        newG.drawString(label.text(), 0, 0);
    }

    @Override
    public Dimension2D preferredSize(Label label, Graphics2D g, Palette palette) {
        return Dimensions.sizeOf(palette.font().getStringBounds(label.text(), g.getFontRenderContext()));
    }

}
