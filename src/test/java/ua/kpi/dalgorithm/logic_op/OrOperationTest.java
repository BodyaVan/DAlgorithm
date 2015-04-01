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
public class OrOperationTest {
    private LogicOperation orOperation;

    @Before
    public void setUp() throws Exception {
        orOperation = new OrOperation();
    }

    @Test
    public void execute_0() throws Exception {
        assertThat(orOperation.execute(0), is(0));
    }

    @Test
    public void execute_1() throws Exception {
        assertThat(orOperation.execute(1), is(1));
    }


    @Test
    public void execute_0_0() throws Exception {
        int result = orOperation.execute(0, 0);
        assertThat(result, is(0));
    }

    @Test
     public void execute_0_1() throws Exception {
        int result = orOperation.execute(0, 1);
        assertThat(result, is(1));
    }

    @Test
    public void execute_1_0() throws Exception {
        int result = orOperation.execute(1, 0);
        assertThat(result, is(1));
    }

    @Test
    public void execute_1_1() throws Exception {
        int result = orOperation.execute(0, 1);
        assertThat(result, is(1));
    }

    @Test(expected = IntIsNotSignalException.class)
    public void badInput_100() throws Exception {
        orOperation.execute(100);
    }

    // ----- Signal Input -----

    @Test
    public void execute_signalInput_0_1() throws Exception {
        Signal result = orOperation.execute(ZERO, ONE);
        assertThat(result, is(ONE));
    }

    @Test
    public void execute_signalInput_1_0_1() throws Exception {
        Signal result = orOperation.execute(ONE, ZERO, ONE);
        assertThat(result, is(ONE));
    }

    //----- With UNDEFINED -----

    @Test
    public void execute_signalInput_0_U() throws Exception {
        Signal result = orOperation.execute(ZERO, UNDEFINED);
        assertThat(result, is(UNDEFINED));
    }

    @Test
    public void execute_signalInput_U_0() throws Exception {
        Signal result = orOperation.execute(UNDEFINED, ZERO);
        assertThat(result, is(UNDEFINED));
    }

    @Test
    public void execute_signalInput_0_U_1() throws Exception {
        Signal result = orOperation.execute(ZERO, UNDEFINED, ONE);
        assertThat(result, is(ONE));
    }

    @Test
    public void execute_signalInput_U_U() throws Exception {
        Signal result = orOperation.execute(UNDEFINED, UNDEFINED);
        assertThat(result, is(UNDEFINED));
    }

    // ----- With D and notD -----

    @Test
    public void execute_signalInput_0_D() throws Exception {
        Signal result = orOperation.execute(ZERO, D);
        assertThat(result, is(D));
    }

    @Test
    public void execute_signalInput_d_0() throws Exception {
        Signal result = orOperation.execute(NOT_D, ZERO);
        assertThat(result, is(NOT_D));
    }

    @Test
    public void execute_signalInput_d_D() throws Exception {
        Signal result = orOperation.execute(NOT_D, D);
        assertThat(result, is(UNDEFINED));
    }

    @Test
    public void execute_signalInput_D_d_1() throws Exception {
        Signal result = orOperation.execute(D, NOT_D, ONE);
        assertThat(result, is(ONE));
    }

    @Test
    public void execute_signalInput_d_d_0() throws Exception {
        Signal result = orOperation.execute(D, D, ZERO);
        assertThat(result, is(D));
    }
}
