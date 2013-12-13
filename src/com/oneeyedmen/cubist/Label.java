package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class Label implements Paintable {

    private static final LabelPainter DEFAULT_PAINTER = new LabelPainter();
    private static final Palette DEFAULT_PALETTE = Palettes.defaultFor(Label.class);

    private final String text;

    public Label(String text) {
        this.text = text;
    }

    @Override
    public void paintOn(Graphics2D g, Dimension2D size) {
        DEFAULT_PAINTER.paint(this, g, size, DEFAULT_PALETTE);
    }

    @Override
    public Dimension2D preferredSize(Graphics2D g) {
        return DEFAULT_PAINTER.preferredSize(this, g);
    }

    public Palette palette() {
        return DEFAULT_PALETTE;
    }

    public String text() {
        return text;
    }
}
