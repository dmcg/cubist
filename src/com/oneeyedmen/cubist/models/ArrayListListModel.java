package com.oneeyedmen.cubist.models;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.oneeyedmen.cubist.listeners.ChangeListener;

import java.util.List;

public class ArrayListListModel<T> implements ListModel<T> {

    private final List<T> items = Lists.newArrayListWithExpectedSize(5);
    private final List<ChangeListener<ListModel<T>>> listeners = Lists.newArrayListWithExpectedSize(1);

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public void add(T item) {
        items.add(item);
        notifyListeners();
    }

    @Override
    public void addListener(ChangeListener<ListModel<T>> listener) {
        listeners.add(listener);
    }

    @Override
    public ImmutableList<T> items() {
        return ImmutableList.copyOf(items);
    }

    private void notifyListeners() {
        for (ChangeListener<ListModel<T>> listener : listeners) {
            listener.stateChanged(this);
        }
    }

}
