package com.oneeyedmen.cubist;

import java.awt.*;

public class Palettes {

    public static final Font DEFAULT_FONT = new Font("Lucida Grande", Font.PLAIN, 13);
    private static final Palette DEFAULT = new SimplePalette(DEFAULT_FONT, Color.BLACK, null);

    public static Palette defaultFor(Class<? extends Paintable> type) {
        return DEFAULT;
    }
}
