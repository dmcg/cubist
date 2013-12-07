package com.oneeyedmen.cubist;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.oneeyedmen.cubist.models.ListModel;

import java.util.Map;

public class ContainerView extends BaseView implements Container {

    private static final HorizontalListPainter DEFAULT_PAINTER = new HorizontalListPainter();

    private final ListModel<Paintable> components = new ListModel<Paintable>();
    private final Map<Paintable, Object> contexts = Maps.newHashMap();

    public ContainerView() {
        this(DEFAULT_PAINTER);
    }

    public ContainerView(Painter<ContainerView> painter) {
        super(painter, null);
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
        container().requestRepaint(paintable,
                new Bounds(
                        myBounds.getX() + bounds.getX(),
                        myBounds.getY() + bounds.getY(),
                        bounds.getWidth(), bounds.getHeight()));
    }

    public Object contextFor(Paintable paintable) {
        return contexts.get(paintable);
    }

}
