package com.oneeyedmen.cubist.models;

import com.google.common.collect.Lists;
import com.oneeyedmen.cubist.listeners.ChangeListener;

import java.util.List;

public class StringLabelModel implements LabelModel {

    private final List<ChangeListener<? super LabelModel>> listeners = Lists.newArrayListWithExpectedSize(1);

    private String text;

    public StringLabelModel(String text) {
        this.text = text;
    }

    @Override
    public String text() {
        return text;
    }

    @Override
    public void addListener(ChangeListener<? super LabelModel> listener) {
        listeners.add(listener);
    }

    @Override
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
