package com.oneeyedmen.cubist;

import java.awt.*;

public class SimplePalette implements Palette {

    private final Font font;
    private final Paint foreground;

    public SimplePalette(Font font, Paint foreground) {
        this.font = font;
        this.foreground = foreground;
    }

    @Override
    public void configure(Graphics2D g) {
        if (font != null) g.setFont(font);
        if (foreground != null) g.setPaint(foreground);
    }

}
