package ru.job4j;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class SingleTrackerTest {

    @Test
    public void whenObject() {
    SingleTracker singleTracker = new SingleTracker();
    SingleTracker singleTracker1 = singleTracker;
    assertSame(singleTracker, singleTracker1);
    }
}