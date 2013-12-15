package com.oneeyedmen.cubist;

import java.awt.*;

public class Palettes {

    private static final Font defaultFont = new Font("Lucida Grande", Font.PLAIN, 13);
    private static final Palette DEFAULT = new SimplePalette(defaultFont, Color.BLACK, null);

    public static Palette defaultFor(Class<? extends Paintable> type) {
        return DEFAULT;
    }
}
