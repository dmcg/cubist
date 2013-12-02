package com.oneeyedmen.cubist;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.util.List;

public class Container implements Paintable {

    private static final HorizontalListPainter DEFAULT_PAINTER = new HorizontalListPainter();

    private final List<PaintableAndContext> components = Lists.newArrayList();

    public void add(Paintable paintable, Object context) {
        components.add(new PaintableAndContext(paintable, context));
    }

    public ImmutableList<PaintableAndContext> components() {
        return ImmutableList.copyOf(components);
    }

    @Override
    public void paintOn(Graphics2D g) {
        painter().paint(this, g);
    }

    @Override
    public Dimension2D preferredSize(Graphics2D g) {
        return painter().preferredSize(this, g);
    }

    protected HorizontalListPainter painter() {
        return DEFAULT_PAINTER;
    }

    public static class PaintableAndContext {
        public final Paintable paintable;
        public final Object context;

        PaintableAndContext(Paintable paintable, Object context) {
            this.paintable = paintable;
            this.context = context;
        }

    }
}
