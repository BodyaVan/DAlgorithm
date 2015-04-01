package ua.kpi.dalgorithm.automate;

import org.junit.Before;
import org.junit.Test;
import ua.kpi.dalgorithm.exceptions.NoOutputsException;
import ua.kpi.dalgorithm.logic_elem.LogicElement;
import ua.kpi.dalgorithm.signal.Signal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ua.kpi.dalgorithm.logic_elem.LogicElementsFactory.*;
import static ua.kpi.dalgorithm.signal.Signal.*;

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

    @Test
    public void automateWith1OrElement() throws Exception {
        automate.setInputsQuantity(2);
        automate.setOutputsQuantity(1);

        LogicElement orLogicElement = createOrLogicElement(2);
        int logicElementIndex = automate.addLogicElement(orLogicElement);

        automate.bindInput(0, logicElementIndex)
                .bindInput(1, logicElementIndex)

                .bindOutput(0, logicElementIndex)
                .setInput(0, Signal.ONE)

                .setInput(1, Signal.ZERO)

                .execute();

        assertThat(automate.getOutput(0), is(ONE));
    }

    @Test
    public void automateWith3Elements() throws Exception {
        automate.setInputsQuantity(4);
        automate.setOutputsQuantity(1);

        int[] elementIndexes = {
                automate.addLogicElement(createOrLogicElement(2)),
                automate.addLogicElement(createNotOrLogicElement(2)),
                automate.addLogicElement(createAndLogicElement(2))
        };

        automate.bindInput(0, elementIndexes[0])
                .bindInput(1, elementIndexes[0])
                .bindInput(2, elementIndexes[1])
                .bindInput(3, elementIndexes[1])

                .bindOutput(0, elementIndexes[2])

                .bindLogicElements(elementIndexes[0], elementIndexes[2])
                .bindLogicElements(elementIndexes[1], elementIndexes[2])

                .setInput(0, ZERO)
                .setInput(1, ONE)
                .setInput(2, ZERO)
                .setInput(3, ONE)

                .execute();

        assertThat(automate.getOutput(0), is(ZERO));
    }
}
