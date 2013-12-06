package com.oneeyedmen.cubist;

import com.google.common.collect.Lists;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class Bounds {

    private final List<ChangeListener<Bounds>> listeners = Lists.newArrayListWithExpectedSize(1);

    private int x;
    private int y;
    private int w;
    private int h;

    public Bounds(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public Rectangle2D toRectangle() {
        return new Rectangle(x, y, w, h);
    }

    public void addListener(ChangeListener<Bounds> listener) {
        listeners.add(listener);
    }


}
