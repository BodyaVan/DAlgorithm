package ua.kpi.dalgorithm.logic_op;

import ua.kpi.dalgorithm.signal.Signal;
import ua.kpi.dalgorithm.signal.SignalMath;

import java.util.List;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public abstract class InvertingLogicOperation implements LogicOperation {
    @Override
    public int execute(int... inputSignals) {
        LogicOperation notInvertingLogicOperation = getNotInvertingLogicElement();
        return inverse(notInvertingLogicOperation.execute(inputSignals));
    }

    private int inverse(int signal) {
        return signal == 0 ? 1 : 0;
    }

    protected abstract LogicOperation getNotInvertingLogicElement();

    @Override
    public Signal execute(Signal... inputSignals) {
        LogicOperation notInvertingLogicOperation = getNotInvertingLogicElement();
        return inverse(notInvertingLogicOperation.execute(inputSignals));
    }

    @Override
    public Signal execute(List<Signal> inputSignals) {
        Signal[] signalsList = inputSignals.toArray(new Signal[0]);
        return execute(signalsList);
    }

    private Signal inverse(Signal signal) {
        return SignalMath.not(signal);
    }

    @Override
    public Signal getUnimportantInput() {
        return getNotInvertingLogicElement().getUnimportantInput();
    }
}
