package com.oneeyedmen.cubist;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.List;

public class LabelModel {

    private String text;
    private final List<ChangeListener> listeners = new ArrayList<ChangeListener>(1);

    public LabelModel(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }

    public void addListener(ChangeListener listener) {
        listeners.add(listener);
    }

    public void setText(String text) {
        boolean changed = this.text() != text;
        this.text = text;
        if (changed)
            fireChangedEvent(new ChangeEvent(this));
    }

    private void fireChangedEvent(ChangeEvent event) {
        for (ChangeListener listener : listeners) {
            listener.stateChanged(event);
        }
    }
}
