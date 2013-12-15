package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public interface Painter<T> {

    public void paint(T thing, Graphics2D g, Palette palette, Dimension2D size);

    Dimension2D preferredSize(T thing, Graphics2D g, Palette palette);
}
