package ua.kpi.dalgorithm.logic_elem;

import ua.kpi.dalgorithm.signal.Signal;

import static ua.kpi.dalgorithm.signal.Signal.UNDEFINED;

/**
 * Created on 10.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class InputComponent implements LogicComponent {
    private Signal input = UNDEFINED;
    private Signal output = UNDEFINED;
    private Signal fault = null;

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
        if (hasFault()) {
            output = fault;
        } else {
            output = input;
        }
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
    public boolean hasFault() {
        return fault != null;
    }

    @Override
    public Signal getFault() {
        return fault;
    }

    @Override
    public void setFault(Signal signal) {
        checkIsFault(signal);
        this.fault = signal;
    }

    private void checkIsFault(Signal signal) {
        if (!signal.isFault()) {
            throw new IllegalArgumentException(
                    String.format("The signal %s is not fault", signal)
            );
        }
    }
}
