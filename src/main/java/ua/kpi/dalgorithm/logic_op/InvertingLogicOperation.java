package ua.kpi.dalgorithm.logic_op;

import ua.kpi.dalgorithm.Signal;
import ua.kpi.dalgorithm.SignalMath;

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

    private Signal inverse(Signal signal) {
        return SignalMath.not(signal);
    }

    @Override
    public Signal getUnimportantInput() {
        return getNotInvertingLogicElement().getUnimportantInput();
    }
}
