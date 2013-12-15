package com.oneeyedmen.cubist;

import java.awt.*;
import java.awt.geom.Dimension2D;

public class SimplePalette implements Palette {

    private final Font font;
    private final Paint foreground;
    private final Paint background;

    public SimplePalette(Font font, Paint foreground, Paint background) {
        this.font = font;
        this.foreground = foreground;
        this.background = background;
    }

    @Override
    public void configure(Graphics2D g) {
        if (font != null) g.setFont(font);
        if (foreground != null) g.setPaint(foreground);
    }

    @Override
    public void paintBackground(Graphics2D g, Dimension2D size) {
        if (background == null)
            return;
        g.setPaint(background);
        g.fillRect(0, 0, (int) size.getWidth(), (int) size.getHeight());
    }

    @Override
    public Font font() {
        return font;
    }

}
