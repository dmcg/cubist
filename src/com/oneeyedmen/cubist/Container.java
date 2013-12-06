package com.oneeyedmen.cubist;

import com.google.common.collect.ImmutableList;

public interface Container {

    ImmutableList<Paintable> contents();

    void requestRepaint(Paintable paintable, Bounds bounds);
}
