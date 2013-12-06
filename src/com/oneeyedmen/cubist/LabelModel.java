package com.oneeyedmen.cubist;

import com.google.common.collect.Lists;

import java.util.List;

public class LabelModel {

    private final List<ChangeListener<? super LabelModel>> listeners = Lists.newArrayListWithExpectedSize(1);

    private String text;

    public LabelModel(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }

    public void addListener(ChangeListener<? super LabelModel> listener) {
        listeners.add(listener);
    }

    public void setText(String text) {
        boolean changed = !this.text().equals(text);
        this.text = text;
        if (changed)
            notifyListeners();
    }

    private void notifyListeners() {
        for (ChangeListener<? super LabelModel> listener : listeners) {
            listener.stateChanged(this);
        }
    }
}
