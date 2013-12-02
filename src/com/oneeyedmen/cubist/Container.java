package com.oneeyedmen.cubist;

import com.google.common.collect.Lists;

import java.util.List;

public class Container {

    private final List<Label> components = Lists.newArrayList();

    public void add(Label component) {
        components.add(component);
    }

    public Iterable<Label> components() {
        return components;
    }
}
