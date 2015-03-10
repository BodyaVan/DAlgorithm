package ua.kpi.dalgorithm.automate;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ua.kpi.dalgorithm.signal.Signal.UNDEFINED;

/**
 * Created on 10.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class AutomateTest {
    private Automate automate;

    @Before
    public void setUp() throws Exception {
        automate = new Automate();
    }

    @Test
    public void createEmptyAutomate_1output_execute_getOutput() throws Exception {
        automate.setOutputsQuantity(1);

        automate.execute();

        assertThat(automate.getOutput(0), is(UNDEFINED));
    }

    @Test(expected = NoOutputsException.class)
    public void createEmptyAutomate_execute() throws Exception {
        automate.execute();
    }

    @Test
    public void createEmptyAutomate_1output_getOutput() throws Exception {
        automate.setOutputsQuantity(1);

        assertThat(automate.getOutput(0), is(UNDEFINED));
    }


}
