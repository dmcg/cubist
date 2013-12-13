package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class LabelPainter implements Painter<Label> {

    @Override public void paint(Label label, Graphics2D g, Dimension2D size, Palette palette) {
        Graphics2D newG = (Graphics2D) g.create();
        palette.configure(newG);
        newG.translate(0, preferredSize(label, newG).getHeight());
        newG.drawString(label.text(), 0, 0);
    }

    @Override
    public Dimension2D preferredSize(Label label, Graphics2D g) {
        return Dimensions.sizeOf(g.getFont().getStringBounds(label.text(), g.getFontRenderContext()));
    }

}
