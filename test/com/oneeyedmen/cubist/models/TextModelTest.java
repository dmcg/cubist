package com.oneeyedmen.cubist.models;

import com.oneeyedmen.cubist.listeners.ChangeListener;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextModelTest {

    @Rule public final JUnitRuleMockery mockery = new JUnitRuleMockery();

    @SuppressWarnings("unchecked")
    private final ChangeListener<TextModel> listener = mockery.mock(ChangeListener.class);

    private final TextModel model = new StringTextModel("Banana");

    @Test public void ctor() {
        assertEquals("Banana", model.text());
    }

    @Test public void setText() {
        assertEquals("Banana", model.text());

        model.setText("Apple");
        assertEquals("Apple", model.text());

        model.addListener(listener);
        mockery.checking(new Expectations() {{
            oneOf(listener).stateChanged(model);
        }});
        model.setText("Kumquat");
        assertEquals("Kumquat", model.text());
    }

    @Test public void no_change_event_when_no_change() {
        assertEquals("Banana", model.text());
        model.addListener(listener);

        mockery.checking(new Expectations() {{
            never(listener).stateChanged(with(any(StringTextModel.class)));
        }});
        model.setText("Banana");
    }
}
