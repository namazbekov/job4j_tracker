package ru.job4j.filter;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void thenToFind(){
        List<Profile> list = new ArrayList<>();
                list.add(new Profile(new Address("New York", "Star", 9, 54)));
                list.add(new Profile(new Address("Moscow", "Pushkina", 15, 12)));
        List<Address> rsl = Profiles.collect(list);
        List<Address> expected = new ArrayList<>();
                expected.add(new Address("New York", "Star", 9, 54));
                expected.add(new Address("Moscow", "Pushkina", 15, 12));
        assertThat(rsl, is(expected));
    }
    @Test
    public void thenToCut(){
        List<Profile> list = new ArrayList<>();
        list.add(new Profile(new Address("New York", "Star", 9, 54)));
        list.add(new Profile(new Address("Moscow", "Pushkina", 15, 12)));
        list.add(new Profile(new Address("New York", "Star", 9, 54)));
        List<Address> rsl = Profiles.collect(list);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Pushkina", 15, 12));
        expected.add(new Address("New York", "Star", 9, 54));
        assertThat(rsl, is(expected));
    }

}