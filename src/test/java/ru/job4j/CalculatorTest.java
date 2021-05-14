package ru.job4j;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest extends TestCase {

        @Test
        public void whenMax1To2Then2() {
            double first = 1;
            double second = 2;
            double third= 3;
            double fourth = 5;
            double result = Calculator.add2( first, second, third, fourth);
            double expected = 5;
            Assert.assertArrayEquals(result, expected);
        }
    }