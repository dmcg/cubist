package com.oneeyedmen.cubist;

import com.oneeyedmen.test.WindowShower;
import org.junit.Ignore;
import org.junit.Test;

import static com.oneeyedmen.cubist.Label.label;

public class RootComponentTest {

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
        new WindowShower(rootComponent).showMaximizedFor(10000);
    }
}
