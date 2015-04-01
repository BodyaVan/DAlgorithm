package ua.kpi.dalgorithm.signal;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ua.kpi.dalgorithm.signal.Signal.*;
import static ua.kpi.dalgorithm.signal.SignalMath.not;

/**
 * Created on 01.04.2015
 *
 * @author Bohdan Vanchuhov
 */
public class NotTest {
    @Test
    public void test_0() throws Exception {
        assertThat(not(ZERO), is(ONE));
    }

    @Test
    public void test_1() throws Exception {
        assertThat(not(ONE), is(ZERO));
    }

    @Test
    public void test_U() throws Exception {
        assertThat(not(UNDEFINED), is(UNDEFINED));
    }

    @Test
    public void test_D() throws Exception {
        assertThat(not(D), is(NOT_D));
    }

    @Test
    public void test_d() throws Exception {
        assertThat(not(NOT_D), is(D));
    }
}
