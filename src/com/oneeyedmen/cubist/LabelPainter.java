package com.oneeyedmen.cubist;


import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;

public class LabelPainter implements Painter<Label> {

    @Override public void paint(Label label, Graphics2D g) {
        Graphics2D newG = (Graphics2D) g.create();
        newG.setColor(Color.BLACK);
        newG.translate(0, preferredSize(label, newG).getHeight());
        newG.drawString(label.model().text(), 0, 0);
    }

    @Override
    public Dimension2D preferredSize(Label thing, Graphics2D g) {
        return new RectangleDimension(g.getFont().getStringBounds(thing.model().text(), g.getFontRenderContext()));
    }

    private static class RectangleDimension extends Dimension2D {
        private final Rectangle2D rectangle;

        RectangleDimension(Rectangle2D rectangle) {
            this.rectangle = rectangle;
        }

        @Override
        public double getWidth() {
            return rectangle.getWidth();
        }

        @Override
        public double getHeight() {
            return rectangle.getHeight();
        }

        @Override
        public void setSize(double width, double height) {
            throw new UnsupportedOperationException("What were they thinking?");
        }
    }
}
