package com.oneeyedmen.cubist;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static org.junit.Assert.assertEquals;

public class LabelModelTest {

    @Rule public final JUnitRuleMockery mockery = new JUnitRuleMockery();

    private final ChangeListener listener = mockery.mock(ChangeListener.class);

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
            oneOf(listener).stateChanged(with(aChangedEventWithSource(model)));
        }});
        model.setText("Kumquat");
        assertEquals("Kumquat", model.text());
    }

    @Test public void no_change_event_when_no_change() {
        assertEquals("Banana", model.text());
        model.addListener(listener);

        mockery.checking(new Expectations() {{
            never(listener).stateChanged(with(any(ChangeEvent.class)));
        }});
        model.setText("Banana");
    }

    private Matcher<ChangeEvent> aChangedEventWithSource(final Object source) {
        return new TypeSafeDiagnosingMatcher<ChangeEvent>() {
            @Override
            protected boolean matchesSafely(ChangeEvent item, Description mismatchDescription) {
                return item.getSource().equals(source);
            }
            @Override
            public void describeTo(Description description) {
                description.appendText("A ChangedEvent with source " + source);
            }
        };
    }
}
