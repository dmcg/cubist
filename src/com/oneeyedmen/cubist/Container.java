package com.oneeyedmen.cubist;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.util.List;
import java.util.Map;

public class Container implements Paintable {

    private static final HorizontalListPainter DEFAULT_PAINTER = new HorizontalListPainter();

    private final List<Paintable> components = Lists.newArrayListWithExpectedSize(4); // will be ListModel<Container>
    private final Map<Paintable, Object> contexts = Maps.newHashMap();

    public void add(Paintable paintable, Object context) {
        components.add(paintable);
        contexts.put(paintable, context);
    }

    public ImmutableList<Paintable> components() {
        return ImmutableList.copyOf(components);
    }

    public Object contextFor(Paintable paintable) {
        return contexts.get(paintable);
    }

    @Override
    public void paintOn(Graphics2D g, Dimension2D size) {
        painter().paint(this, g, size);
    }

    @Override
    public Dimension preferredSize(Graphics2D g) {
        return painter().preferredSize(this, g);
    }

    protected HorizontalListPainter painter() {
        return DEFAULT_PAINTER;
    }
}
