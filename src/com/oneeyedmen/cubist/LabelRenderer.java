package com.oneeyedmen.cubist;


import java.awt.*;

public class LabelRenderer {

    public void render(Label label, Graphics2D g) {
        g.setColor(Color.BLACK);
        String text = label.model().text();
        float lineHeight = (float) g.getFont().getStringBounds(text, g.getFontRenderContext()).getHeight();
        g.drawString(text, 0, lineHeight);
    }
}
