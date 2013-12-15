package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public interface Palette
{
    void configure(Graphics2D g);

    void paintBackground(Graphics2D g, Dimension2D size);

    Font font();
}
