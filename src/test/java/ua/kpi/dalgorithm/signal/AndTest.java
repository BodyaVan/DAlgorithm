package ua.kpi.dalgorithm.signal;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static ua.kpi.dalgorithm.signal.Signal.*;
import static ua.kpi.dalgorithm.signal.SignalMath.and;

/**
 * Created on 01.04.2015
 *
 * @author Bohdan Vanchuhov
 */
public class AndTest {
    @Test
    public void test_0_0() throws Exception {
        assertThat(and(ZERO, ZERO), is(ZERO));
    }

    @Test
    public void test_0_1() throws Exception {
        assertThat(and(ZERO, ONE), is(ZERO));
    }

    @Test
    public void test_1_0() throws Exception {
        assertThat(and(ONE, ZERO), is(ZERO));
    }

    @Test
    public void test_1_1() throws Exception {
        assertThat(and(ONE, ONE), is(ONE));
    }

    //----- With UNDEFINED -----

    @Test
    public void test_0_U() throws Exception {
        assertThat(and(ZERO, UNDEFINED), is(ZERO));
    }

    @Test
    public void test_U_1() throws Exception {
        assertThat(and(UNDEFINED, ONE), is(UNDEFINED));
    }

    @Test
    public void test_U_U() throws Exception {
        assertThat(and(UNDEFINED, UNDEFINED), is(UNDEFINED));
    }

    // ----- With D and notD -----

    @Test
    public void test_1_D() throws Exception {
        assertThat(and(ONE, D), is(D));
    }

    @Test
    public void test_d_1() throws Exception {
        assertThat(and(NOT_D, ONE), is(NOT_D));
    }

    @Test
    public void test_d_0() throws Exception {
        assertThat(and(NOT_D, ZERO), is(ZERO));
    }

    @Test
    public void test_d_D() throws Exception {
        assertThat(and(NOT_D, D), is(UNDEFINED));
    }
}
