package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }
    @Test
    public void whenInvalidInputNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(3));
    }
    @Test
    public void whenInvalidInputManyNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0","2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(0));
    }
    @Test
    public void whenNegativeValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int result = input.askInt("Enter menu:");
        assertThat(result, is(-1));
    }

}