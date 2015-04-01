package ua.kpi.dalgorithm.logic_op;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
}
