package com.oneeyedmen.cubist;

public class Label {

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
}
