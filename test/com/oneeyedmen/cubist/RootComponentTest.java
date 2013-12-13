package com.oneeyedmen.cubist;

import com.oneeyedmen.test.WindowShower;
import org.junit.Ignore;
import org.junit.Test;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;

import static com.oneeyedmen.cubist.TextView.label;

public class RootComponentTest {

    @Ignore("manual")
    @Test
    public void show() throws InterruptedException {
        ContainerView container = new ContainerView(new BorderLayoutPainter());
        final TextView northTextView = label("North");
        container.add(northTextView, BorderLayoutPainter.Position.NORTH);
        container.add(label("South"), BorderLayoutPainter.Position.SOUTH);

        JPanel panel = new JPanel(new BorderLayout());
        JTextField editor = new JTextField();
        panel.add(editor, BorderLayout.SOUTH);
        panel.add(new RootComponent(container), BorderLayout.CENTER);

        editor.getDocument().addDocumentListener(new SynchronisingDocumentListener(northTextView));

        new WindowShower(panel).showMaximizedFor(10000);
    }

    private void setLabelText(DocumentEvent e, TextView textView) {
        try {
            textView.model().setText(e.getDocument().getText(0, e.getDocument().getLength()));
        } catch (BadLocationException x) {
            throw new RuntimeException(x);
        }
    }

    private class SynchronisingDocumentListener implements DocumentListener {
        private final TextView textView;

        public SynchronisingDocumentListener(TextView textView) {
            this.textView = textView;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            setLabelText(e, textView);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            setLabelText(e, textView);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            setLabelText(e, textView);
        }
    }
}
