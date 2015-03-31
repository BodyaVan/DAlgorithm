package ua.kpi.dalgorithm.logic_op;

import ua.kpi.dalgorithm.signal.Signal;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public abstract class GenericLogicOperation implements LogicOperation {
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

    @Override
    public Signal execute(List<Signal> inputSignals) {
        Signal[] signalsList = inputSignals.toArray(new Signal[0]);
        return execute(signalsList);
    }

    protected abstract Signal execute(Signal s1, Signal s2);
}
