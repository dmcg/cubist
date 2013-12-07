package com.oneeyedmen.cubist;

import com.oneeyedmen.cubist.listeners.ChangeListener;
import com.oneeyedmen.cubist.models.LabelModel;
import com.oneeyedmen.cubist.models.StringLabelModel;

public class Label extends BaseView {

    private static final LabelPainter DEFAULT_PAINTER = new LabelPainter();
    private static final Palette DEFAULT_PALETTE = Palettes.defaultFor(Label.class);

    private final LabelModel model;
    private final ChangeListener<Object> myChangeListener = new MyChangeListener();


    public static Label label(String text) {
        return new Label(new StringLabelModel(text));
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
