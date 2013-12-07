package com.oneeyedmen.cubist;

import com.google.common.collect.Lists;

import java.awt.geom.Rectangle2D;
import java.util.List;

public class Bounds extends Rectangle2D.Double {

    private final List<ChangeListener<Bounds>> listeners = Lists.newArrayListWithExpectedSize(1);

    public Bounds(double x, double y, double w, double h) {
        super(x, y, w, h);
    }

    public void addListener(ChangeListener<Bounds> listener) {
        listeners.add(listener);
    }

    @Override
    public void setRect(Rectangle2D r) {
        super.setRect(r);
        // TODO - notify listeners
    }
}
