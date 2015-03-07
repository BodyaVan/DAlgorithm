package ua.kpi.dalgorithm.logic_elem;

import ua.kpi.dalgorithm.Signal;

import java.util.Arrays;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public abstract class GenericLogicElement implements LogicElement {
    @Override
    public int execute(int... inputSignals) {
        checkInputSignals(inputSignals);

        return Arrays.stream(inputSignals)
                .reduce(this::execute)
                .getAsInt();
    }

    protected void checkInputSignals(int... inputSignals) {
        if (!isLegalInputSignal(inputSignals)) {
            throw new IntIsNotSignalException();
        }
    }

    private boolean isLegalInputSignal(int... input) {
        return Arrays.stream(input)
                .allMatch(this::isLegalInputSignal);
    }


    private boolean isLegalInputSignal(int inputSignal) {
        return inputSignal == 0 || inputSignal == 1;
    }

    protected abstract int execute(int s1, int s2);

    @Override
    public Signal execute(Signal... inputSignals) {
        return Arrays.stream(inputSignals)
                .reduce(this::execute)
                .get();
    }

    protected abstract Signal execute(Signal s1, Signal s2);
}
