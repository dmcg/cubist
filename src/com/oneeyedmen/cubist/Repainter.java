package com.oneeyedmen.cubist;

import com.google.common.collect.Lists;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class Repainter {

    private static final Repainter current = new Repainter();

    private List<PendingRepaint> dirtyRegions = Lists.newLinkedList();

    public static Repainter current() {
        return current;
    }

    public void addDirtyRegion(Paintable thing, Bounds bounds) {
        dirtyRegions.add(new PendingRepaint(thing, bounds));
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                repaint();
            }
        });
    }

    private void repaint() {
        Iterator<PendingRepaint> iterator = dirtyRegions.iterator();
        while (iterator.hasNext()) {
            PendingRepaint pendingRepaint = iterator.next();
//            pendingRepaint.thing.paintOn();
        }
    }

    private static class PendingRepaint {
        public final Paintable thing;
        public final Bounds bounds;

        public PendingRepaint(Paintable thing, Bounds bounds) {
            this.thing = thing;
            this.bounds = bounds;
        }
    }
}
