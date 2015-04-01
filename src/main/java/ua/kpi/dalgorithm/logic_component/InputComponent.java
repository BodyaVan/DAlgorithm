package ua.kpi.dalgorithm.logic_component;

import ua.kpi.dalgorithm.signal.Signal;

import static ua.kpi.dalgorithm.signal.Signal.UNDEFINED;

/**
 * Created on 10.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class InputComponent implements LogicComponent {
    private int index;

    private Signal input = UNDEFINED;
    private Signal output = UNDEFINED;

    public InputComponent() {
    }

    public InputComponent(Signal input) {
        this.input = input;
    }

    public Signal getInput() {
        return input;
    }

    public void setInput(Signal input) {
        this.input = input;
    }

    public void execute() {
        output = input;
    }

    public Signal getOutput() {
        return output;
    }

    @Override
    public int getInputsQuantity() {
        return 0;
    }

    @Override
    public void setInputsQuantity(int inputsQuantity) {
        throw new UnsupportedOperationException("Should not set inputs quantity for input component");
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }
}
