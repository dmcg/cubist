package com.oneeyedmen.cubist;

import java.awt.*;

public class ContainerPainter implements Painter<Container> {


    @Override public void paint(Container container, Graphics2D g) {
        for (Paintable each: container.components()) {
            each.paintOn(g);
        }
    }
}
