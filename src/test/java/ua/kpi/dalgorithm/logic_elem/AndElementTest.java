package ua.kpi.dalgorithm.logic_elem;

import org.junit.Before;
import org.junit.Test;
import ua.kpi.dalgorithm.Signal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static ua.kpi.dalgorithm.Signal.*;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class AndElementTest {
    private LogicElement andElement;

    @Before
    public void setUp() throws Exception {
        andElement = new AndElement();
    }

    @Test
    public void execute_0() throws Exception {
        assertThat(andElement.execute(0), is(0));
    }

    @Test
    public void execute_1() throws Exception {
        assertThat(andElement.execute(1), is(1));
    }


    @Test
    public void execute_0_0() throws Exception {
        int result = andElement.execute(0, 0);
        assertThat(result, is(0));
    }

    @Test
    public void execute_0_1() throws Exception {
        int result = andElement.execute(0, 1);
        assertThat(result, is(0));
    }

    @Test
    public void execute_1_0() throws Exception {
        int result = andElement.execute(1, 0);
        assertThat(result, is(0));
    }

    @Test
    public void execute_1_1() throws Exception {
        int result = andElement.execute(1, 1);
        assertThat(result, is(1));
    }

    @Test
    public void execute_0_0_0() throws Exception {
        int result = andElement.execute(0, 0, 0);
        assertThat(result, is(0));
    }

    @Test
    public void execute_1_1_1() throws Exception {
        int result = andElement.execute(1, 1, 1);
        assertThat(result, is(1));
    }

    @Test(expected = IntIsNotSignalException.class)
    public void badInput_100() throws Exception {
        andElement.execute(100);
    }

    @Test(expected = IntIsNotSignalException.class)
    public void badInput_m1_0() throws Exception {
        andElement.execute(-1, 0);
    }

    @Test(expected = IntIsNotSignalException.class)
    public void badInput_10_0() throws Exception {
        andElement.execute(10, 0);
    }

    @Test
    public void execute_signalInput_0_1() throws Exception {
        Signal result = andElement.execute(ZERO, ONE);
        assertThat(result, is(ZERO));
    }

    @Test
    public void execute_signalInput_1_0_1() throws Exception {
        Signal result = andElement.execute(ONE, ZERO, ONE);
        assertThat(result, is(ZERO));
    }
}
