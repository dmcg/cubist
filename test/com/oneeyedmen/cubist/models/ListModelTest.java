package com.oneeyedmen.cubist.models;

import com.oneeyedmen.cubist.ListListener;
import com.oneeyedmen.cubist.models.ListModel;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListModelTest {

    @Rule public JUnitRuleMockery mockery = new JUnitRuleMockery();

    private final ListListener listener = mockery.mock(ListListener.class);

    private final ListModel<String> model = new ListModel<String>();

    @Test public void test() {
        model.addListener(listener);
        assertEquals(0, model.size());

        mockery.checking(new Expectations() {{
            oneOf(listener).listChanged();
        }});
        model.add("one");
        assertEquals(1, model.size());
    }
}
