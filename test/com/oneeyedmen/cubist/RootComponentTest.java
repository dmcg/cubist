package com.oneeyedmen.cubist;

import org.junit.Ignore;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static com.oneeyedmen.cubist.Label.label;

public class RootComponentTest {

    private final Frame frame = new Frame();

    @Ignore("manual")
    @Test
    public void show() throws InterruptedException {
        Container container = new Container() {
            @Override
            protected Painter<Container> painter() {
                return new BorderLayoutPainter();
            }
        };
        container.add(label("North"), BorderLayoutPainter.Position.NORTH);
        container.add(label("South"), BorderLayoutPainter.Position.SOUTH);

        RootComponent rootComponent = new RootComponent(container);

        frame.add(rootComponent);
        frame.setSize(800, 600);
        frame.setVisible(true);
        Thread.sleep(10000);
    }
}
