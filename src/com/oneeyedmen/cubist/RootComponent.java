package com.oneeyedmen.cubist;

import com.google.common.collect.ImmutableList;

import java.awt.*;

/**
 * The bridge between Cubist and AWT.
 */
public class RootComponent extends Component implements Container {

    private final Paintable paintable;

    public RootComponent(Paintable paintable) {
        this.paintable = paintable;
        if (paintable instanceof Containable)
            ((Containable) paintable).setContainer(this);
    }

    @Override
    public void paint(Graphics g) {
        paintable.paintOn((Graphics2D) g, getSize());
    }

    @Override
    public ImmutableList<Paintable> contents() {
        return ImmutableList.of(paintable);
    }

    @Override
    public void requestRepaint(Paintable paintable, Bounds bounds) {
        // TODO - better rounding
        repaint((int) bounds.getX(), (int) bounds.getY(),
                (int) bounds.getWidth(), (int) bounds.getHeight());
    }
}
