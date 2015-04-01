package ua.kpi.dalgorithm.signal;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static ua.kpi.dalgorithm.signal.Signal.*;
import static ua.kpi.dalgorithm.signal.SignalMath.or;

/**
 * Created on 01.04.2015
 *
 * @author Bohdan Vanchuhov
 */
public class OrTest {
    @Test
    public void test_0_0() throws Exception {
        assertThat(or(ZERO, ZERO), is(ZERO));
    }

    @Test
    public void test_0_1() throws Exception {
        assertThat(or(ZERO, ONE), is(ONE));
    }

    @Test
    public void test_1_0() throws Exception {
        assertThat(or(ONE, ZERO), is(ONE));
    }

    @Test
    public void test_1_1() throws Exception {
        assertThat(or(ONE, ONE), is(ONE));
    }

    //----- With UNDEFINED -----

    @Test
    public void test_0_U() throws Exception {
        assertThat(or(ZERO, UNDEFINED), is(UNDEFINED));
    }

    @Test
    public void test_U_0() throws Exception {
        assertThat(or(UNDEFINED, ZERO), is(UNDEFINED));
    }

    @Test
    public void test_U_1() throws Exception {
        assertThat(or(UNDEFINED, ONE), is(ONE));
    }

    @Test
    public void test_U_U() throws Exception {
        assertThat(or(UNDEFINED, UNDEFINED), is(UNDEFINED));
    }

    // ----- With D and notD -----

    @Test
    public void test_0_D() throws Exception {
        assertThat(or(ZERO, D), is(D));
    }

    @Test
    public void test_d_0() throws Exception {
        assertThat(or(NOT_D, ZERO), is(NOT_D));
    }

    @Test
    public void test_d_D() throws Exception {
        assertThat(or(NOT_D, D), is(UNDEFINED));
    }

    @Test
    public void test_D_1() throws Exception {
        assertThat(or(D, ONE), is(ONE));
    }

    @Test
    public void test_d_d() throws Exception {
        assertThat(or(D, D), is(D));
    }
}
