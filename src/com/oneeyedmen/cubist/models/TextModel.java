package com.oneeyedmen.cubist.models;

import com.oneeyedmen.cubist.listeners.ChangeListener;

public interface TextModel {
    String text();

    void addListener(ChangeListener<? super TextModel> listener);

    void setText(String text);
}
