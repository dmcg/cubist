package com.oneeyedmen.cubist;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

public class ListModel<T> {

    private final List<T> items = Lists.newArrayListWithExpectedSize(5);
    private final List<ListListener> listeners = Lists.newArrayListWithExpectedSize(1);

    public int size() {
        return 0;
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
