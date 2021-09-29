package ru.job4j.collection;


import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobDescByNameTest {

    @Test
    public void jobDestByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobDescByName());
        List<Job> expected = Arrays.asList(jobs.get(0), jobs.get(1), jobs.get(2));
        assertThat(jobs, is(expected));
    }
}