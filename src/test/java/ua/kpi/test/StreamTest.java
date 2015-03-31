package ua.kpi.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class StreamTest {
    @Test
    public void anyMatch_true() throws Exception {
        boolean result = IntStream.of(1, 2, 3, 5)
                .allMatch(a -> a < 10);

        assertThat(result, is(true));
    }

    @Test
    public void anyMatch_false() throws Exception {
        boolean result = IntStream.of(1, 2, 3, 100)
                .allMatch(a -> a < 10);

        assertThat(result, is(false));
    }
}
