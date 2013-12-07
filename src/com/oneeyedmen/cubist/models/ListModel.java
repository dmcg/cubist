package com.oneeyedmen.cubist.models;

import com.google.common.collect.ImmutableList;
import com.oneeyedmen.cubist.listeners.ChangeListener;

public interface ListModel<T> {
    int size();

    void add(T item);

    void addListener(ChangeListener<ListModel<T>> listener);

    ImmutableList<T> items();
}
