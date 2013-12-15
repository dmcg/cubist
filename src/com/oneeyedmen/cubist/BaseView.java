package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class BaseView implements View {

    private final Painter painter;
    private final Bounds bounds = new Bounds(0, 0, 0, 0);
    private final Palette palette;

    private Container container;

    public BaseView(Painter painter, Palette palette) {
        this.painter = painter;
        this.palette = palette;
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

    @Override
    public void paintOn(Graphics2D g, Dimension2D size) {
        painter().paint(this, g, palette(), size);
    }

    @Override
    public Dimension2D preferredSize(Graphics2D g) {
        return painter().preferredSize(this, g, palette());
    }

    protected Painter painter() {
        return painter;
    }

    protected Palette palette() {
        return palette;
    }

}
