package com.oneeyedmen.cubist;


import java.awt.*;

public class LabelRenderer {

    public void render(Graphics2D g, Label label, float x, float y) {
        g.setColor(Color.BLACK);
        String text = label.model().text();
        float lineHeight = (float) g.getFont().getStringBounds(text, g.getFontRenderContext()).getHeight();
        g.drawString(text, x, lineHeight + y);
    }
}
