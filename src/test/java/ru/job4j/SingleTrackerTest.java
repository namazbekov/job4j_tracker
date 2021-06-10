package ru.job4j;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class SingleTrackerTest {

    @Test
    public void whenObject() {
        SingleTracker singleTracker = SingleTracker.getInstance();
        SingleTracker singleTracker1 = SingleTracker.getInstance();
        assertSame(singleTracker, singleTracker1);
    }
}