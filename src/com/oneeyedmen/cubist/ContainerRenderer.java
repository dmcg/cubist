package com.oneeyedmen.cubist;

import java.awt.*;

public class ContainerRenderer {


    public void render(Container container, Graphics2D g) {
        LabelRenderer renderer = new LabelRenderer();
        for (Label component : container.components()) {
            renderer.render(component, g);
        }
    }
}
