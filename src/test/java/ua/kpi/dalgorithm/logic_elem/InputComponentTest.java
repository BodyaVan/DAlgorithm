package ua.kpi.dalgorithm.logic_elem;

import org.junit.Before;
import org.junit.Test;
import ua.kpi.dalgorithm.signal.Signal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static ua.kpi.dalgorithm.signal.Signal.D;
import static ua.kpi.dalgorithm.signal.Signal.ONE;

/**
 * Created on 10.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class InputComponentTest {
    private InputComponent inputComponent;

    @Before
    public void setUp() throws Exception {
        inputComponent = new InputComponent();
    }

    @Test
    public void setInput_execute_getOutput() throws Exception {
        inputComponent.setInput(Signal.ONE);
        inputComponent.execute();

        assertThat(inputComponent.getOutput(), is(Signal.ONE));
    }

    @Test
    public void setInput_getOutput() throws Exception {
        inputComponent.setInput(Signal.ONE);

        assertThat(inputComponent.getOutput(), is(Signal.UNDEFINED));
    }

    //--------------------------------------------------

    @Test
    public void execute_getOutput() throws Exception {
        inputComponent.execute();

        assertThat(inputComponent.getOutput(), is(Signal.UNDEFINED));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setInputsQuantity() throws Exception {
        inputComponent.setInputsQuantity(10);
    }

    @Test
    public void hasFault() throws Exception {
        assertThat(inputComponent.hasFault(), is(false));
    }

    @Test
    public void getFault() throws Exception {
        assertThat(inputComponent.getFault(), is(nullValue()));
    }

    @Test
    public void setFault_getFault() throws Exception {
        inputComponent.setFault(D);
        assertThat(inputComponent.getFault(), is(D));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setIncorrectFault() throws Exception {
        inputComponent.setFault(ONE);
    }

    @Test
    public void setInput_setFault_execute_getOutput() throws Exception {
        inputComponent.setInput(ONE);
        inputComponent.setFault(D);

        inputComponent.execute();

        assertThat(inputComponent.getOutput(), is(D));
    }
}
