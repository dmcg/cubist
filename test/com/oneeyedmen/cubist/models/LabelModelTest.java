package com.oneeyedmen.cubist.models;

import com.oneeyedmen.cubist.ChangeListener;
import com.oneeyedmen.cubist.models.LabelModel;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LabelModelTest {

    @Rule public final JUnitRuleMockery mockery = new JUnitRuleMockery();

    @SuppressWarnings("unchecked")
    private final ChangeListener<LabelModel> listener = mockery.mock(ChangeListener.class);

    private final LabelModel model = new LabelModel("Banana");

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
            never(listener).stateChanged(with(any(LabelModel.class)));
        }});
        model.setText("Banana");
    }
}
