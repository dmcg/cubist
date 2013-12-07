package com.oneeyedmen.cubist.models;

import com.oneeyedmen.cubist.listeners.ChangeListener;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListModelTest {

    @Rule public JUnitRuleMockery mockery = new JUnitRuleMockery();

    private final ChangeListener<ListModel<String>> listener = mockery.mock(ChangeListener.class);

    private final ListModel<String> model = new ArrayListListModel<String>();

    @Test public void test() {
        model.addListener(listener);
        assertEquals(0, model.size());

        mockery.checking(new Expectations() {{
            oneOf(listener).stateChanged(model);
        }});
        model.add("one");
        assertEquals(1, model.size());
    }
}
