package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class Label extends BaseView {

    private static final LabelPainter DEFAULT_PAINTER = new LabelPainter();
    private static final Palette DEFAULT_PALETTE = Palettes.defaultFor(Label.class);

    private final LabelModel model;
    private final ChangeListener<Object> myChangeListener = new MyChangeListener();


    public static Label label(String text) {
        return new Label(new LabelModel(text));
    }

    public Label(LabelModel model) {
        super(DEFAULT_PAINTER, DEFAULT_PALETTE);
        this.model = model;
        model.addListener(myChangeListener);
    }

    public LabelModel model() {
        return model;
    }

    private class MyChangeListener implements ChangeListener<Object> {
        @Override
        public void stateChanged(Object subject) {
            requestRepaint();
        }
    }

    private void requestRepaint() {
        container().requestRepaint(this, bounds());
    }
}
