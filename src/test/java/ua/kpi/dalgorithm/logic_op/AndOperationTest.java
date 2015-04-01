package ua.kpi.dalgorithm.logic_op;

import org.junit.Before;
import org.junit.Test;
import ua.kpi.dalgorithm.signal.Signal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static ua.kpi.dalgorithm.signal.Signal.*;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class AndOperationTest {
    private LogicOperation andOperation;

    @Before
    public void setUp() throws Exception {
        andOperation = new AndOperation();
    }

    @Test
    public void execute_0() throws Exception {
        assertThat(andOperation.execute(0), is(0));
    }

    @Test
    public void execute_1() throws Exception {
        assertThat(andOperation.execute(1), is(1));
    }


    @Test
    public void execute_0_0() throws Exception {
        int result = andOperation.execute(0, 0);
        assertThat(result, is(0));
    }

    @Test
    public void execute_0_1() throws Exception {
        int result = andOperation.execute(0, 1);
        assertThat(result, is(0));
    }

    @Test
    public void execute_1_0() throws Exception {
        int result = andOperation.execute(1, 0);
        assertThat(result, is(0));
    }

    @Test
    public void execute_1_1() throws Exception {
        int result = andOperation.execute(1, 1);
        assertThat(result, is(1));
    }

    @Test
    public void execute_0_0_0() throws Exception {
        int result = andOperation.execute(0, 0, 0);
        assertThat(result, is(0));
    }

    @Test
    public void execute_1_1_1() throws Exception {
        int result = andOperation.execute(1, 1, 1);
        assertThat(result, is(1));
    }

    @Test(expected = IntIsNotSignalException.class)
    public void badInput_100() throws Exception {
        andOperation.execute(100);
    }

    @Test(expected = IntIsNotSignalException.class)
    public void badInput_m1_0() throws Exception {
        andOperation.execute(-1, 0);
    }

    @Test(expected = IntIsNotSignalException.class)
    public void badInput_10_0() throws Exception {
        andOperation.execute(10, 0);
    }

    // ----- Signal Input -----

    @Test
    public void execute_signalInput_0_1() throws Exception {
        Signal result = andOperation.execute(ZERO, ONE);
        assertThat(result, is(ZERO));
    }

    @Test
    public void execute_signalInput_1_0_1() throws Exception {
        Signal result = andOperation.execute(ONE, ZERO, ONE);
        assertThat(result, is(ZERO));
    }

    //----- With UNDEFINED -----

    @Test
    public void execute_signalInput_0_U() throws Exception {
        Signal result = andOperation.execute(ZERO, UNDEFINED);
        assertThat(result, is(ZERO));
    }

    @Test
    public void execute_signalInput_U_1() throws Exception {
        Signal result = andOperation.execute(UNDEFINED, ONE);
        assertThat(result, is(UNDEFINED));
    }

    @Test
    public void execute_signalInput_0_U_1() throws Exception {
        Signal result = andOperation.execute(ZERO, UNDEFINED, ONE);
        assertThat(result, is(ZERO));
    }

    @Test
    public void execute_signalInput_U_U() throws Exception {
        Signal result = andOperation.execute(UNDEFINED, UNDEFINED);
        assertThat(result, is(UNDEFINED));
    }

    // ----- With D and notD -----

    @Test
    public void execute_signalInput_1_D() throws Exception {
        Signal result = andOperation.execute(ONE, D);
        assertThat(result, is(D));
    }

    @Test
    public void execute_signalInput_d_1() throws Exception {
        Signal result = andOperation.execute(NOT_D, ONE);
        assertThat(result, is(NOT_D));
    }

    @Test
    public void execute_signalInput_d_D() throws Exception {
        Signal result = andOperation.execute(NOT_D, D);
        assertThat(result, is(UNDEFINED));
    }

    @Test
    public void execute_signalInput_D_d_0() throws Exception {
        Signal result = andOperation.execute(D, NOT_D, ZERO);
        assertThat(result, is(ZERO));
    }

    @Test
    public void execute_signalInput_d_d_1() throws Exception {
        Signal result = andOperation.execute(D, D, ONE);
        assertThat(result, is(D));
    }
}
