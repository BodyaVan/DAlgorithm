package ua.kpi.dalgorithm.logic_elem;

import org.junit.Before;
import org.junit.Test;
import ua.kpi.dalgorithm.Signal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class OrElementTest {
    private LogicElement orElement;

    @Before
    public void setUp() throws Exception {
        orElement = new OrElement();
    }

    @Test
    public void execute_0() throws Exception {
        assertThat(orElement.execute(0), is(0));
    }

    @Test
    public void execute_1() throws Exception {
        assertThat(orElement.execute(1), is(1));
    }


    @Test
    public void execute_0_0() throws Exception {
        int result = orElement.execute(0, 0);
        assertThat(result, is(0));
    }

    @Test
     public void execute_0_1() throws Exception {
        int result = orElement.execute(0, 1);
        assertThat(result, is(1));
    }

    @Test
    public void execute_1_0() throws Exception {
        int result = orElement.execute(1, 0);
        assertThat(result, is(1));
    }

    @Test
    public void execute_1_1() throws Exception {
        int result = orElement.execute(0, 1);
        assertThat(result, is(1));
    }

    @Test(expected = IntIsNotSignalException.class)
    public void badInput_100() throws Exception {
        orElement.execute(100);
    }

    @Test
    public void execute_signalInput_0_1() throws Exception {
        Signal result = orElement.execute(Signal.ZERO, Signal.ONE);
        assertThat(result, is(Signal.ONE));
    }

    @Test
    public void execute_signalInput_1_0_1() throws Exception {
        Signal result = orElement.execute(Signal.ONE, Signal.ZERO, Signal.ONE);
        assertThat(result, is(Signal.ONE));
    }
}
