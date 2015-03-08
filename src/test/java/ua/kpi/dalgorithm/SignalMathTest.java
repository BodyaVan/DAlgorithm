package ua.kpi.dalgorithm;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static ua.kpi.dalgorithm.Signal.*;
import static ua.kpi.dalgorithm.SignalMath.and;
import static ua.kpi.dalgorithm.SignalMath.or;

public class SignalMathTest {
    @Test
    public void and_0_1() throws Exception {
        assertThat(and(ZERO, ONE), is(ZERO));
    }

    @Test
    public void or_0_1() throws Exception {
        assertThat(or(ZERO, ONE), is(ONE));
    }

    @Test
    public void not_0() throws Exception {
        assertThat(not(ZERO), is(ONE));
    }
}