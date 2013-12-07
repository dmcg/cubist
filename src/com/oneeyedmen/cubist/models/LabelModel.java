package com.oneeyedmen.cubist.models;

import com.oneeyedmen.cubist.listeners.ChangeListener;

public interface LabelModel {
    String text();

    void addListener(ChangeListener<? super LabelModel> listener);

    void setText(String text);
}
