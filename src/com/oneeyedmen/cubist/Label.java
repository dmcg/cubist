package com.oneeyedmen.cubist;

import java.awt.*;

public class Label implements Paintable {

    private static final LabelPainter DEFAULT_PAINTER = new LabelPainter();

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
    public void paintOn(Graphics2D g) {
        painter().paint(this, g);
    }

    protected LabelPainter painter() {
        return DEFAULT_PAINTER;
    }


}
