package com.oneeyedmen.cubist;

import java.awt.*;

public class RootComponent extends Component {

    private final Paintable paintable;

    public RootComponent(Paintable paintable) {
        this.paintable = paintable;
    }

    @Override
    public void paint(Graphics g) {
        paintable.paintOn((Graphics2D) g, getSize());
    }
}
