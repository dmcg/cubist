package com.oneeyedmen.cubist;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.util.Map;

public class ContainerView implements Paintable, Container, Containable, Bounded {

    private static final HorizontalListPainter DEFAULT_PAINTER = new HorizontalListPainter();

    private final ListModel<Paintable> components = new ListModel<Paintable>();
    private final Map<Paintable, Object> contexts = Maps.newHashMap();
    private final Painter<ContainerView> painter;
    private final Bounds bounds = new Bounds(0, 0, 0, 0);

    private Container container;

    public ContainerView() {
        this(DEFAULT_PAINTER);
    }

    public ContainerView(Painter<ContainerView> painter) {
        this.painter = painter;
    }

    public void add(Paintable paintable, Object context) {
        components.add(paintable);
        if (paintable instanceof Containable)
            ((Containable) paintable).setContainer(this);
        contexts.put(paintable, context);
    }

    public ImmutableList<Paintable> contents() {
        return components.items();
    }

    @Override
    public void requestRepaint(Paintable paintable, Bounds bounds) {
        Bounds myBounds = bounds();
        container().requestRepaint(paintable, new Bounds(
                myBounds.x() + bounds.x(), myBounds.y() + bounds.y(), bounds.w(), bounds.h()));
    }

    public Object contextFor(Paintable paintable) {
        return contexts.get(paintable);
    }

    @Override
    public void paintOn(Graphics2D g, Dimension2D size) {
        painter().paint(this, g, size, null);
    }

    @Override
    public Dimension2D preferredSize(Graphics2D g) {
        return painter().preferredSize(this, g);
    }

    public Painter<ContainerView> painter() {
        return painter;
    }

    @Override
    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public Container container() {
        return container;
    }

    @Override
    public Bounds bounds() {
        return bounds;
    }
}
