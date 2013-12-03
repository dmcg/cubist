package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public interface Paintable {

    public void paintOn(Graphics2D g, Dimension2D size);

    Dimension2D preferredSize(Graphics2D g);
}
