package com.oneeyedmen.cubist;

import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;

public class Dimensions {

    public static Dimension2D size(final double width, final double height) {
        return new Dimension2D() {
            @Override
            public double getWidth() {
                return width;
            }

            @Override
            public double getHeight() {
                return height;
            }

            @Override
            public void setSize(double width, double height) {
                throw new UnsupportedOperationException("Not supported");
            }

            @Override
            public String toString() {
                return "[" + width + " x " + height + "]";
            }
        };
    }

    public static Dimension2D sizeOf(final Rectangle2D rectangle) {
        return size(rectangle.getWidth(), rectangle.getHeight());
    }
}
