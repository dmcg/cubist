package com.oneeyedmen.cubist.models;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.oneeyedmen.cubist.ListListener;

import java.util.List;

public class ListModel<T> {

    private final List<T> items = Lists.newArrayListWithExpectedSize(5);
    private final List<ListListener> listeners = Lists.newArrayListWithExpectedSize(1);

    public int size() {
        return items.size();
    }

    public void add(T item) {
        items.add(item);
        notifyListeners();
    }

    public void addListener(ListListener listener) {
        listeners.add(listener);
    }

    public ImmutableList<T> items() {
        return ImmutableList.copyOf(items);
    }

    private void notifyListeners() {
        for (ListListener listener : listeners) {
            listener.listChanged();
        }
    }

}
