package ua.kpi.dalgorithm;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static ua.kpi.dalgorithm.Signal.ONE;
import static ua.kpi.dalgorithm.Signal.ZERO;
import static ua.kpi.dalgorithm.SignalMath.and;
import static ua.kpi.dalgorithm.SignalMath.or;

public class SignalMathTest {
    @Test
    public void testAnd_0_1() throws Exception {
        assertThat(and(ZERO, ONE), is(ZERO));
    }

    @Test
    public void testOr_0_1() throws Exception {
        assertThat(or(ZERO, ONE), is(ONE));
    }

    @Test
    public void testNot_0() throws Exception {
        assertThat(SignalMath.not(ZERO), is(ONE));
    }
}