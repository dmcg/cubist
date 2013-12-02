package com.oneeyedmen.cubist;

import java.awt.*;

public interface Painter<T> {

    public void paint(T thing, Graphics2D g);
}
