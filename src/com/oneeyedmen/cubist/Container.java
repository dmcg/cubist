package com.oneeyedmen.cubist;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.awt.*;
import java.util.List;

public class Container implements Paintable {

    private static final ContainerPainter DEFAULT_PAINTER = new ContainerPainter();

    private final List<Paintable> components = Lists.newArrayList();

    public void add(Paintable paintable) {
        components.add(paintable);
    }

    public Iterable<Paintable> components() {
        return Iterables.unmodifiableIterable(components);
    }

    @Override
    public void paintOn(Graphics2D g) {
        painter().paint(this, g);
    }

    protected ContainerPainter painter() {
        return DEFAULT_PAINTER;
    }
}
