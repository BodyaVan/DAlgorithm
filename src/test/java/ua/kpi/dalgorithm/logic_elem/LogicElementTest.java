package ua.kpi.dalgorithm.logic_elem;

import org.junit.Before;
import org.junit.Test;
import ua.kpi.dalgorithm.exceptions.NoMoreInputException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ua.kpi.dalgorithm.signal.Signal.ONE;
import static ua.kpi.dalgorithm.signal.Signal.UNDEFINED;
import static ua.kpi.dalgorithm.signal.Signal.ZERO;

/**
 * Created on 30.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class LogicElementTest {

    private LogicElement orLogicElement;

    @Before
    public void setUp() throws Exception {
        orLogicElement = LogicElementsFactory.createOrLogicElement();
    }

    @Test
    public void addInputs_execute() throws Exception {
        orLogicElement.addInput(ZERO);
        orLogicElement.addInput(ONE);

        orLogicElement.execute();

        assertThat(orLogicElement.getOutput(), is(ONE));
    }

    @Test
    public void withoutExecute() throws Exception {
        orLogicElement.addInput(ZERO);
        orLogicElement.addInput(ONE);

        assertThat(orLogicElement.getOutput(), is(UNDEFINED));
    }

    @Test
    public void setInput() throws Exception {
        orLogicElement.addInput(ZERO);
        orLogicElement.addInput(ONE);

        orLogicElement.setInput(1, ZERO);

        orLogicElement.execute();

        assertThat(orLogicElement.getOutput(), is(ZERO));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setInput_wrongValue() throws Exception {
        orLogicElement.addInput(ZERO);
        orLogicElement.addInput(ONE);

        orLogicElement.setInput(2, ZERO);
    }

    // ----- setInputsQuantity (limitedInputs) -----

    @Test(expected = IllegalArgumentException.class)
    public void setInputsQuantity_illegalValue() throws Exception {
        orLogicElement.setInputsQuantity(0);
    }

    @Test
    public void setInputsQuantity_isLimitedInputs() throws Exception {
        orLogicElement.setInputsQuantity(1);

        assertThat(orLogicElement.isLimitedInputs(), is(true));
    }

    @Test
    public void setInputsQuantity_addAllInputs_execute() throws Exception {
        orLogicElement.setInputsQuantity(2);

        orLogicElement.addInput(ZERO);
        orLogicElement.addInput(ZERO);

        orLogicElement.execute();

        assertThat(orLogicElement.getOutput(), is(ZERO));
    }

    @Test
    public void setInputsQuantity_addPartOfInputs_execute() throws Exception {
        orLogicElement.setInputsQuantity(2);

        orLogicElement.addInput(ZERO);

        orLogicElement.execute();

        assertThat(orLogicElement.getOutput(), is(UNDEFINED));
    }

    @Test(expected = NoMoreInputException.class)
    public void setInputsQuantity_toManyInputs() throws Exception {
        orLogicElement.setInputsQuantity(1);

        orLogicElement.addInput(ZERO);
        orLogicElement.addInput(ZERO);
    }

    @Test
    public void setInputsQuantity_setInput() throws Exception {
        orLogicElement.setInputsQuantity(2);

        orLogicElement.setInput(1, ONE);
        orLogicElement.setInput(0, ZERO);

        orLogicElement.execute();

        assertThat(orLogicElement.getOutput(), is(ONE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setInputsQuantity_setInput_illegalValue() throws Exception {
        orLogicElement.setInputsQuantity(2);

        orLogicElement.setInput(2, ONE);
    }
}
