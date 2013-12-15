package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class Label implements Paintable {

    private static final LabelPainter DEFAULT_PAINTER = new LabelPainter();
    private static final Palette DEFAULT_PALETTE = Palettes.defaultFor(Label.class);

    private final String text;
    private final Palette palette;

    public Label(String text) {
        this(text, DEFAULT_PALETTE);
    }

    public Label(String text, Palette palette) {
        this.text = text;
        this.palette = palette;
    }

    @Override
    public void paintOn(Graphics2D g, Dimension2D size) {
        DEFAULT_PAINTER.paint(this, g, palette, size);
    }

    @Override
    public Dimension2D preferredSize(Graphics2D g) {
        return DEFAULT_PAINTER.preferredSize(this, g, palette());
    }

    public Palette palette() {
        return palette;
    }

    public String text() {
        return text;
    }
}
