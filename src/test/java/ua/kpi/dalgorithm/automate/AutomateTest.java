package ua.kpi.dalgorithm.automate;

import org.junit.Before;
import org.junit.Test;
import ua.kpi.dalgorithm.exceptions.NoOutputsException;
import ua.kpi.dalgorithm.logic_component.LogicElement;
import ua.kpi.dalgorithm.signal.Signal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ua.kpi.dalgorithm.logic_component.LogicElementsFactory.*;
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
        automate.setOutputsQuantity(1)
                .execute();

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
        automate.setInputsQuantity(2)
                .setOutputsQuantity(1);

        LogicElement orLogicElement = createOrLogicElement(2);
        int logicElementIndex = automate.addElement(orLogicElement);

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
        automate.setInputsQuantity(4)
                .setOutputsQuantity(1);

        int[] elementIndexes = {
                automate.addElement(createOrLogicElement(2)),
                automate.addElement(createNotOrLogicElement(2)),
                automate.addElement(createAndLogicElement(2))
        };

        automate.bindInput(0, elementIndexes[0])
                .bindInput(1, elementIndexes[0])
                .bindInput(2, elementIndexes[1])
                .bindInput(3, elementIndexes[1])

                .bindOutput(0, elementIndexes[2])

                .bindElements(elementIndexes[0], elementIndexes[2])
                .bindElements(elementIndexes[1], elementIndexes[2])

                .setInput(0, ZERO)
                .setInput(1, ONE)
                .setInput(2, ZERO)
                .setInput(3, ONE)

                .execute();

        assertThat(automate.getOutput(0), is(ZERO));
    }

    @Test
    public void automateWith3Elements_addingByName() throws Exception {
        automate.setInputsQuantity(4)
                .setOutputsQuantity(1)

                .setInputName(0, "a")
                .setInputName(1, "b")
                .setInputName(2, "c")
                .setInputName(3, "d")

                .setOutputName(0, "y")

                .addElement(createOrLogicElement(2), "0")
                .addElement(createNotOrLogicElement(2), "1")
                .addElement(createAndLogicElement(2), "2")

                .bindInput("a", "0")
                .bindInput("b", "0")
                .bindInput("c", "1")
                .bindInput("d", "1")

                .bindOutput("y", "2")

                .bindElements("0", "2")
                .bindElements("1", "2")

                .setInput("a", ZERO)
                .setInput("b", ONE)
                .setInput("c", ZERO)
                .setInput("d", ONE)

                .execute();

        assertThat(automate.getOutput("y"), is(ZERO));
    }
}
