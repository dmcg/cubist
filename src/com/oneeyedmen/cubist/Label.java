package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class Label implements Paintable {

    private static final LabelPainter DEFAULT_PAINTER = new LabelPainter();
    private static final Palette DEFAULT_PALETTE = Palettes.defaultFor(Label.class);

    private final LabelModel model;

    public static Label label(String text) {
        return new Label(new LabelModel(text));
    }

    public Label(LabelModel model) {
        this.model = model;
    }

    public LabelModel model() {
        return model;
    }

    @Override
    public void paintOn(Graphics2D g, Dimension2D size) {
        painter().paint(this, g, size, palette());
    }

    public Palette palette() {
        return DEFAULT_PALETTE;
    }

    @Override
    public Dimension2D preferredSize(Graphics2D g) {
        return painter().preferredSize(this, g);
    }

    protected LabelPainter painter() {
        return DEFAULT_PAINTER;
    }
}
