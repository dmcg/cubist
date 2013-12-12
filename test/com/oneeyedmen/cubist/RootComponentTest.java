package com.oneeyedmen.cubist;

import com.oneeyedmen.test.WindowShower;
import org.junit.Ignore;
import org.junit.Test;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;

import static com.oneeyedmen.cubist.Label.label;

public class RootComponentTest {

    @Ignore("manual")
    @Test
    public void show() throws InterruptedException {
        ContainerView container = new ContainerView(new BorderLayoutPainter());
        final Label northLabel = label("North");
        container.add(northLabel, BorderLayoutPainter.Position.NORTH);
        container.add(label("South"), BorderLayoutPainter.Position.SOUTH);

        JPanel panel = new JPanel(new BorderLayout());
        JTextField editor = new JTextField();
        panel.add(editor, BorderLayout.SOUTH);
        panel.add(new RootComponent(container), BorderLayout.CENTER);

        editor.getDocument().addDocumentListener(new SynchronisingDocumentListener(northLabel));

        new WindowShower(panel).showMaximizedFor(10000);
    }

    private void setLabelText(DocumentEvent e, Label label) {
        try {
            label.model().setText(e.getDocument().getText(0, e.getDocument().getLength()));
        } catch (BadLocationException x) {
            throw new RuntimeException(x);
        }
    }

    private class SynchronisingDocumentListener implements DocumentListener {
        private final Label label;

        public SynchronisingDocumentListener(Label label) {
            this.label = label;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            setLabelText(e, label);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            setLabelText(e, label);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            setLabelText(e, label);
        }
    }
}
