package com.oneeyedmen.cubist;

import java.awt.*;

public class Palettes {

    private static final Palette DEFAULT = new SimplePalette(null, Color.BLACK);

    public static Palette defaultFor(Class<? extends Paintable> type) {
        return DEFAULT;
    }
}
