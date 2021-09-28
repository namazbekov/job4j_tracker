package ru.job4j.collection;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobByPriorityTest {

    @Test
    public void jobByPriorityTest() {
        List<Job> jobs = List.of(
                new Job("frog", 4),
                new Job("dog", 2),
                new Job("cat", 0)
        );
        Collections.sort(jobs, new JobByPriority());
        List<Job> expected = Arrays.asList(jobs.get(0), jobs.get(1), jobs.get(2));
        assertThat(jobs, is(expected));
    }

}