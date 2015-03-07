package ua.kpi.dalgorithm;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static ua.kpi.dalgorithm.Signal.*;
import static ua.kpi.dalgorithm.SignalMath.and;

public class SignalMathTest {

    @Test
    public void and_0_1() throws Exception {
        assertThat(and(ZERO, ONE), is(ZERO));
    }

    @Test
    public void or() throws Exception {

    }

    @Test
    public void not() throws Exception {

    }
}