package com.oneeyedmen.cubist;


import java.awt.*;

public class LabelRenderer {

    private final String text;

    public LabelRenderer(String text) {
        this.text = text;
    }

    public void render(Graphics2D g, float x, float y) {
        g.setColor(Color.BLACK);
        g.drawString(text, x, y);
    }
}
