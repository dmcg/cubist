package com.oneeyedmen.cubist;

import com.oneeyedmen.cubist.listeners.ChangeListener;
import com.oneeyedmen.cubist.models.TextModel;
import com.oneeyedmen.cubist.models.StringTextModel;

public class TextView extends BaseView {

    private static final TextViewPainter DEFAULT_PAINTER = new TextViewPainter();
    private static final Palette DEFAULT_PALETTE = Palettes.defaultFor(TextView.class);

    private final TextModel model;
    private final ChangeListener<Object> myChangeListener = new MyChangeListener();


    public static TextView label(String text) {
        return new TextView(new StringTextModel(text));
    }

    public TextView(TextModel model) {
        super(DEFAULT_PAINTER, DEFAULT_PALETTE);
        this.model = model;
        model.addListener(myChangeListener);
    }

    public TextModel model() {
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
